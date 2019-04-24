package test;

import java.util.LinkedList;
import java.util.List;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MoveAction;

import com.sun.glass.ui.TouchInputSupport;
import com.sun.org.apache.bcel.internal.generic.ReturnaddressType;
import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;

/**  
* @Title: MovingBricks.java  
* @Package   
* @Description: TODO  
* @author:小豪
* @date 2018年12月7日  
* @version V1.8
*/

/**  
* @ClassName: MovingBricks  
* @Description: TODO
* @author 小豪  
* @date 2018年12月7日  
*    
*/
public class MovingBricksTest{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testMoveBricks();
	}
	public static void testMoveBricks() {
		int personNum = 2;
		int brickNum = 2;
		
		List<Brick> bricks =  new LinkedList<Brick>();
		for (int i=0;i<brickNum;i++) {
			bricks.add(new Brick(String.valueOf(i+1)));
		}
		
		Person persons[] = new Person[personNum];
		for(int i =0; i<personNum; i++) {
			persons[i] = new Person(String.valueOf(i+1), null, null);
			if(i!=0) {
				persons[i].setLeftNeig(persons[i-1]);
				persons[i-1].setRightNeig(persons[i]);
			}
		}
		Person.setBricks(bricks);
		Thread threads[] = new Thread[persons.length];
		for (int i=0; i<threads.length; i++) {
			threads[i] = new Thread(persons[i],"thread"+(i+1)) ;
			threads[i].start() ;
		}
		try {
			for (Thread thread : threads) {
				thread.join();
			}
		} catch (InterruptedException e) {
			e.printStackTrace(); 
		}
		System.out.println("the end of main thread .") ;
	}
}

class Person implements Runnable{
	private String id;
	private Person leftNeig,rightNeig;
	private Hand leftHand,rightHand;
	private static List<Brick> bricks;
	public Person(String id,Person left,Person right) {
		this.id = id;
		this.leftNeig = left;
		this.rightNeig = right;
		leftHand = new Hand();
		rightHand = new Hand();
	}
	public static void setBricks(List<Brick> bri) {
		Person.bricks = bri;
	}
	public boolean isFirst() {
		return leftNeig==null;
	}
	public boolean isLast() {
		return rightNeig==null;
	}
	public void setLeftNeig(Person p) {
		this.leftNeig = p;
	}
	public void setRightNeig(Person p) {
		this.rightNeig = p;
	}
	public String toString() {
		return "Person "+this.id;
	}
	public void run() {
		int moveBrickNum = 0;
		int toBeMoveBrickNum = this.bricks.size();
		while(moveBrickNum<toBeMoveBrickNum) {
			System.out.println(this+" the "+moveBrickNum+" iter");
			this.getBrickFromLeftNeig();
			this.moveBrickFromLeftHandToRight();
			moveBrickNum++;
		}
	}
	public void getBrickFromLeftNeig() {
		Brick brick = null;
		if(isFirst()) {
			if(Person.bricks.size()==0) {
				System.out.println(Thread.currentThread().getName()+"bricks has moved out!");
				return;
			}
			else {
				brick = Person.bricks.remove(0);
				this.leftHand.putBrick(brick,"0 left");
				System.out.printf("%s %s is picked up by %s! \n",Thread.currentThread().getName(),brick,this);
				return;
			}
		}
		else {
			brick = this.leftNeig.rightHand.passBrick("1 right");
			this.leftHand.putBrick(brick,"1 left");
			try {
				Thread.sleep(30);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.printf("%s %s is moved from %s to %s \n",Thread.currentThread().getName(),brick,this.leftNeig,this);
			return;
		}
	}
	public void moveBrickFromLeftHandToRight() {
		Brick brick = this.leftHand.passBrick(this+"left");
		System.out.println(this+"left pass "+brick);
		this.rightHand.putBrick(brick,this+"right");
		if(isLast()) {
			this.rightHand.passBrick("right");
			System.out.printf("%s %s is moved from left to "
					+ "right of %s.  %s has arrived! \n",Thread.currentThread().getName(),
					brick,this,brick);
		}
		else {
			System.out.printf("%s %s is moved from left to right of %s \n",
					Thread.currentThread().getName(),brick,this);
			try {
				Thread.sleep(30);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	} 
} 
class Hand{
	private Brick onHandBrick ;
	public Hand() {
		
	}
	public  boolean brickOnHand() {
		return onHandBrick != null;
	}
	public void putBrick(Brick brick,String hand) {
		synchronized (this) {
			while(brickOnHand()) {
				try {
					System.out.println(Thread.currentThread().getName()+" put wait "+hand
							+"because of "+this.onHandBrick);
					this.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			this.onHandBrick = brick;
			this.notifyAll();
		}
	}
	public Brick passBrick(String hand) {
		synchronized (this) {
			while(!brickOnHand()) {
				try {
					System.out.println(Thread.currentThread().getName()+" pass wait "+hand);
					this.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			Brick temp = this.onHandBrick;
			this.onHandBrick = null;
			this.notifyAll();
			return temp;
		}
	}
}
class Brick{
	private String id;
	public Brick(String i) {
		this.id = i;
	}
	public String toString() {
		return "Brick "+this.id;
	}
}
