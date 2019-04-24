package chpt_06;

import java.nio.channels.ScatteringByteChannel;

import javax.xml.stream.events.StartDocument;

/**
 * for extends demo
 * 
 * @author Ping
 * @date 2018Äê10ÔÂ12ÈÕ
 */
public class ExtendsDemo_01 {

	public static void main(String[] args) {

		Person stu = new Student("zhangsan",18,"CS","SoftwareEngineering") ;
	//	Person p2 = new Teacher("",18,"CS","SoftwareEngineering") ;
		Person teacher = new Teacher("lisi",38,"CS","Prefessor") ;
		
		Person p1 = new Person("wangwu", 30, "Staff") ;
		
	
		p1.work(); 
		p1 = stu ;
		p1.work();
		p1 = teacher ;
		p1.work();
		
		
	}

}


class Person {
	String name ;
	int age ;
	private String school ;
	String major ;
	
	public Person() {
		
	}
	public Person(String name, int age, String school) {
		super();
		this.name = name;
		this.age = age;
		this.school = school;
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
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	
	public void work() {
		System.out.println("do some work !");
	}
	
	
}

class Student extends Person {
	String major ;
	
	public Student() {
		super();
		
	}
	
	public Student(String name, int age, String school) {
		//super() ;
		super(name, age, school) ; //this
		this.major = "CS" ;
		super.major= "CS" ;
		
		super.setSchool("Math");
	}
	public Student(String name, int age, String school, String major) {
		super(name, age, school) ; //this
		this.major = major ;

	}
	
	@Override
	public void work() {
		System.out.println("stu " + this.name + " attend classes "
	          + " and join associations. " );
	}
	

	
	
	
}
class Teacher extends Person {
	String prefession ;
	public Teacher() {
		super();
	}
	public Teacher(String name, int age, String school) {
		super(name, age, school);
		this.prefession = "Prefessor" ;
	}
	
	public Teacher(String name, int age, String school,String prefession) {
		super(name, age, school);
		this.prefession = prefession;
	}
	@Override
	public void work() {
		System.out.println("teacher " + this.name + " gives classes "
	          + " and join conferences. " );
	}
	
	
}