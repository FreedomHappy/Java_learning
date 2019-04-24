
/**  
* @Title: CheckBag.java  
* @Package   
* @Description: TODO  
* @author 小豪  
* @date 2018年10月20日  
* @version V1.8
*/



abstract class Stuff{
	public abstract String toString();
}
class Book extends Stuff{
	String bookName;
	String press;
	Book(String b, String p){
		this.bookName = b;
		this.press = p;
	}
	@Override
	public String toString() {
		return bookName+" with "+press;
	}
}

class Cloth extends Stuff{
	String brand;
	String color;
	Cloth(String b, String c){
		this.brand = b;
		this.color = c;
	}
	@Override
	public String toString() {
		return brand+" with "+color;
	}
}

abstract class Bag{
	Stuff[] stuffs;
	int size;
	int currentSize;
	Bag(){}
	Bag(int s){
		this.size = s;
		this.stuffs = new Stuff[s];
		this.currentSize = 0;
	}
	public abstract  void putStuff(Stuff stuff); 
	public Stuff getStuff(int index) {
		
		if (index>=this.currentSize) {
			System.out.println("There is not such index for stuff in the bag!");
			return null;
		}
		Stuff temp = this.stuffs[index];
		this.currentSize = this.currentSize-1;
		for(int i=index; i<this.currentSize; i++) {
			this.stuffs[i] = this.stuffs[i+1];
		}
		System.out.printf("The stuff with index %d is gotten from bag!\n",index);
		return temp;
	}
	public void printAllStuffs() {
		for(int i=0; i<this.currentSize; i++) {
			System.out.println(this.stuffs[i].toString());
		}
	}
}

class SchoolBag extends Bag{
	SchoolBag(int s){
		super(s);
	}
	
	@Override
	public void putStuff(Stuff stuff) {
		if(!(stuff instanceof Book)) {
			System.out.println(stuff.toString()+"can't put into the Schoolbag!");
		}
		else if(currentSize==size) {
			System.out.println("The schoolbag is full!");
		}
		else {
			this.stuffs[this.currentSize++] = stuff;
		}
	}
}

class Luggage extends Bag{
	Luggage(int s){
		super(s);
	}
	
	@Override
	public void putStuff(Stuff stuff) {
		if(!(stuff instanceof Cloth)) {
			System.out.println(stuff.toString()+"can't put into the luggage!");
		}
		else if(this.currentSize==size) {
			System.out.println("The luggage is full!");
		}
		else {
			this.stuffs[this.currentSize++] = stuff;
		}
	}
}
/**  
* @ClassName: CheckBag  
* @Description: 测试主类
* @author 小豪  
* @date 2018年10月20日  
*    
*/
public class CheckBag {

	public static void main(String[] args) {
		//create stuffs
		Stuff[] stuffs = new Stuff[10];
		for (int i=0; i<stuffs.length; i++) {
			if(i%2==0) {
				stuffs[i]=new Book("book "+i,"press "+i);
			}
			else {
				stuffs[i]=new Cloth("Nike "+i,"color "+i);
			}
		}
		//create two bags with size 5 and 4, respectively
		Bag luggage = new Luggage(5);
		Bag schoolBag = new SchoolBag(4);
		//put stuff into bags
		for(int i=0; i<stuffs.length; i++) {
			luggage.putStuff(stuffs[i]);
			schoolBag.putStuff(stuffs[i]);
		}
		//get stuffs from bags
		luggage.getStuff(0);
		schoolBag.getStuff(1);
		schoolBag.getStuff(5);
		//print the stuffs from bags
		luggage.printAllStuffs();
		schoolBag.printAllStuffs();
	}

}