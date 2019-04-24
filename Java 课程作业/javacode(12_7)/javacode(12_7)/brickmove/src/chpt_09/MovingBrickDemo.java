package chpt_09;



import java.util.LinkedList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class MovingBrickDemo {

	public static void main(String[] args) {
		List<Brick> bricks = new LinkedList<Brick>() ;
		for (int i=0; i<10; i++) {
			bricks.add(new Brick(String.valueOf(i))) ;
		}
		
		Person[] persons = new Person[2] ;
	
		for (int i=0; i<persons.length; i++) {
			persons[i] = new Person(String.valueOf(i),  null, null) ;
			if (i != 0 ) {
				persons[i-1].rightNeib = persons[i] ; 
				persons[i].leftNeib = persons[i-1] ;
			} 
		}
		Person.setBricks(bricks);
		
		Thread[] threads = new Thread[persons.length] ;
		for (int i=0; i<threads.length; i++) {
			threads[i] = new Thread(persons[i]) ;
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

class Person implements Runnable {
	static final Logger logger = LogManager.getLogger(Person.class) ;
	String id ;
	Person leftNeib ;
	Person rightNeib ;
	Hand leftHand, rightHand ;
	static List<Brick> bricks ;
	public Person(String id, Person leftNeib, Person rightNeib) {
		this.id = id ;
		this.leftNeib = leftNeib ;
		this.rightNeib = rightNeib ;
		leftHand = new Hand();
		rightHand = new Hand();
	}

	public static void setBricks(List<Brick> bricks) {
		Person.bricks = bricks ;
	}
	
	
	@Override
	public void run() {
		int movedBrickNum = 0 ;
		int toBeMovedBrickNum = Person.bricks.size();
		while (movedBrickNum < toBeMovedBrickNum) {
			this.getBrickFromLeftNeib(); 
			this.passBrickFromLeftHandToRight();
			movedBrickNum++ ;
		}
		logger.info(" {} finished bricks moving . ", this);
	}
	public boolean isFirst() {
		return this.leftNeib == null ;
	}
	public boolean isLast() {
		return this.rightNeib == null ;
	}
	
	private void getBrickFromLeftNeib() {
		
		Brick brick = null ;
		if (this.leftNeib == null) {
			if (Person.bricks.size() == 0) {
				logger.info(" the brickBuffer was moved out ! ");
				return ;
			}
			brick = Person.bricks.remove(0) ;
			logger.info(" the brick {} was picked from BRICKS by {} ", brick, this);
			
		} else {
			brick = this.leftNeib.rightHand.passBrick() ;
			logger.info(" the brick {} was picked from the right hand of {} ", brick, this.leftNeib);
			
		}
		this.leftHand.putBrick(brick);
		logger.info(" the brick {} was moved to left hand of {} ", brick, this);
		
	}
	
	private void passBrickFromLeftHandToRight() {
		Brick brick = this.leftHand.passBrick() ;
		this.rightHand.putBrick(brick) ;
		if (this.isLast()) {
			logger.info("[Arrived] the brick {} was arrived ! ",this.rightHand.passBrick());
		} else {
			logger.info("the brick {} was moved from left hand of {} to his right hand ", brick, this);
		}
	}
	
	
	@Override 
	public String toString() {
		return " PERSON " + this.id ;
	}
	
	
	
	
	
	
}

class Hand {
	Brick onHandBrick ;
	public boolean brickOnHand() {
		return this.onHandBrick != null ;
	}
	
	public synchronized void putBrick(Brick brick) {
		
		while (brickOnHand()) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.onHandBrick = brick ;
		this.notifyAll();
		
	}
	public synchronized Brick passBrick() {
		
		while (!this.brickOnHand()) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace(); 
			}
		}
		
		Brick temp = this.onHandBrick ;
		this.onHandBrick = null ;
		this.notifyAll(); 
		return temp ;
	}
		
		
	
	
}

class Brick {
	String id ;
	
	public Brick(String id) {
		this.id = id ;
	}
	@Override
	public String toString() {
		return "BRICK " + this.id ;
	}
	
	
}
