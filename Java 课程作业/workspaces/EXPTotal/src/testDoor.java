import java.util.Scanner;

import com.sun.org.apache.bcel.internal.generic.ReturnaddressType;

/**  
* @Title: testDoor.java  
* @Package   
* @Description: TODO  
* @author:С��
* @date 2018��11��10��  
* @version V1.8
*/

/**  
* @ClassName: testDoor  
* @Description: TODO
* @author С��  
* @date 2018��11��10��  
*    
*/

/*
 * ��������
 * */
public class testDoor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		testGuest();
		testEmployee();
	}
	/**
	 * ����Guest��Admin,Door,������pressBell,openDoor,closeDoor��
	 */
	public static void testGuest() {
		System.out.println("**************** test guest *******************");
		Guest guest = new Guest("guest_1");
		// ͨ��ValidatorFactory��ȡ��Ӧ��validator,���Դ���ElectornicDoor
		Validator validator = ValidatorFactory.getValidator("pa");
		Door door = new ElectornicDoor(validator);
		Admin admin = new Admin("admin_1");
		guest.pressBell(door);
		admin.openDoorForGuest(door);
		admin.closeDoor(door);
		//guest.pressBell(door);
		admin.openDoorForGuest(door);
		admin.closeDoor(door);
		System.out.println("************** the end *******************");
	}
	public static void testEmployee() {
		System.out.println("***************test employee**************");
		Employee employee = new Employee("employee_1");
		// ͨ��ValidatorFactory��ȡ��Ӧ��validator�����Դ���ElectornicDdoor
		Validator validator = ValidatorFactory.getValidator("fi");
		Door door = new ElectornicDoor(validator);
		employee.openDoor(door);
		employee.closeDoor(door);
		// ������һ��validator
		validator = ValidatorFactory.getValidator("ca");
		door = new ElectornicDoor(validator);
		employee.openDoor(door);
		employee.closeDoor(door);
		//�����������
		employee.openDoor(door);
		employee.closeDoor(door);
		System.out.println("*************the end************");
	}
}



// Door ��
abstract class Door{
	public String OPEN= "open";
	public String CLOSED= "closed";
	public String RINGED="ringed";
	public String SILENCE="silence";
	protected String doorState;
	protected String bellState;
	public Door() {
		doorState = CLOSED;
		bellState = SILENCE;
	}
	public abstract void  open(Guest guest);
	public abstract void  close();
}

class ElectornicDoor extends Door{
	// ʹ����֤���ӿ�
	private Validator validator;
	
	public ElectornicDoor(Validator validator) {this.validator=validator;}
	
	@Override
	// ����
	public void open(Guest guest) {
		if(guest instanceof Admin) {
			//�ÿ�ΪAdmin���
			if (this.bellState.equals(this.RINGED)) {
				// ����
				if (this.doorState.equals(this.CLOSED)) {
					this.doorState=OPEN;
					this.bellState=this.SILENCE;
					System.out.println("The door was open by Admin "+guest.getName()+"...");
				}
			}
			else {
				// ��û��
				System.out.println("The door does not to be open,since there is not guest outside...");
			}
		}
		else if(guest instanceof Employee) {
			//�ÿ�ΪEmployee���
			System.out.println("Hello, employee! To open the door, you need to be valided by Validator");
			if(validator.inputAndValide()) {
				// ��֤�ɹ�
				System.out.println("Welcom "+guest.getName()+" , the door was open for you...");
				this.doorState=this.OPEN;
			}
			else {
				//��֤ʧ��
				System.out.println("Sorry "+guest.getName()+" ,your input was not right...");
			}
		}
		else {
			// �ÿ�Ϊ����guest���
			bellState = RINGED;
			System.out.println("The door is ringing now...");
		}
	}
	// ����
	public void close() {
		if(this.doorState.equals(this.CLOSED)) {
			System.out.println("The door can not be closed it was already closed. ...");
		}
		else {
			this.doorState = this.CLOSED;
			System.out.println("The door was closed...");
		}
	}
}

//Guest ��
class Guest{
	private String name;
	
	public Guest(String n) {this.name=n;}
	public void pressBell(Door door){
		System.out.println("Guest "+this.name+ " press the door...");
		door.open(this);
	}
	public String getName() {
		return this.name;
	}
}

class Employee extends Guest{
	public Employee(String n) {super(n);}
	public void openDoor(Door door){
		door.open(this);
	} 
	public void closeDoor(Door door) {door.close();}
}

class Admin extends Employee{
	public Admin(String n) {super(n);}
	public void openDoorForGuest(Door door) {
		door.open(this);
	}
}
//��֤���ӿ�
interface Validator{
	public abstract boolean inputAndValide();
}
// ��֤��
class Computer{
	private String[] pwds= {"fi123", "ca123"};
	public boolean isExisted(String pwd) {
		for(int i=0; i<this.pwds.length;i++) {
			if(this.pwds[i].equals(pwd)) {
				return true;
			}
		}
		return false;
	}
}
abstract class ComputerValidator{
	private Computer computer;
	
	public ComputerValidator() {
		this.computer=new Computer();
	}
	protected String input() {
		System.out.println("--- please input your password:");
		Scanner scan = new Scanner(System.in);
		String str1 = null;
		if (scan.hasNext()) {
           str1 = scan.next();
        }
		return str1;
	}
	protected boolean isValided(String pwd) {
		return this.computer.isExisted(pwd);
	}
}
class PassVD extends ComputerValidator implements Validator{
	public PassVD() {super();}
	@Override
	protected String input() {
		System.out.println("--- this is Pass validator----");
		return super.input();
	}
	public boolean inputAndValide() {
		String pwd = this.input();
		return this.isValided(pwd);
	}
}
class CardVD extends ComputerValidator implements Validator{
	public CardVD() {super();}
	@Override
	protected String input() {
		System.out.println("--- this is Card validator----");
		return super.input();
	}
	public boolean inputAndValide() {
		String pwd = this.input();
		return this.isValided(pwd);
	}
}
class FigerVD extends ComputerValidator implements Validator{
	public FigerVD() {super();}
	@Override
	protected String input() {
		System.out.println("--- this is Finger validator----");
		return super.input();
	}
	public boolean inputAndValide() {
		String pwd = this.input();
		return this.isValided(pwd);
	}
}

//��֤������
class ValidatorFactory{
	public static Validator getValidator(String type) {
		if("pa".equals(type)) {
			return new PassVD();
		}
		else if("ca".equals(type)) {
			return new CardVD();
		}
		else if("fi".equals(type)) {
			return new FigerVD();
		}
		else return null;
	} 
}

