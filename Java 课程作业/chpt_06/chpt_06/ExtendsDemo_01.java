package chpt_06;

import org.w3c.dom.NamedNodeMap;

public class ExtendsDemo_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class SchoolPeople {
	
	String name ;
	int age ;
	
	
	public SchoolPeople() {
		super();
	}
	public SchoolPeople(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public void work() {
		System.out.println("The school People " + this.name + " does some work !");
	}
}


class Student extends SchoolPeople {
	
	String school ;
	String name ;
	
	
	
	public Student() {
		super() ;
	}
	
	public Student(String name , int age ) {
	 // super 
		super(name, age) ;
		this.school = "CS" ;
		
	}
	public Student(String name , int age, String school) {
		 // super 
			super(name, age) ;
			this.school = school ;
			
	}
	@Override
	public void work() {
		System.out.println("Student " + super.name + " attends lectures and " + 
		          " joins associations ." ) ;
		super.work() ;
		
		
	}


}

class Teacher extends SchoolPeople {
	String school ;
	String profession ;
	
	
	
	public Teacher() {
		super() ;
	}
	
	public Teacher(String name , int age ) {
	 // super 
		super(name, age) ;
		this.school = "CS" ;
		
	}
	public Teacher(String name , int age, String school) {
		 // super 
			super(name, age) ;
			this.school = school ;
			
	}
	
	@Override
	public void work() {
		System.out.println("Teacher " + this.name + " gives lectures and " + 
		          " join conferences ." ) ;
		
		
	}
	
	
	
	
	
}




