
/**
* @Title: Employee_main.java
* @Package 
* @author 小豪
* @date 2018年9月23日
* @version V1.8
*/

public class Employee_main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee wang=new Employee("143","wang",4000);
		System.out.println("id:"+wang.getId()+"  name:"+wang.getName()+"\n  基础工资:"+String.format("%.1f", wang.getbSalary()));
		wang.countSalaryUP(0.8);
		System.out.println("增长额: "+String.format("%.1f", wang.getSalaryUP()));
		System.out.println("工资总额: "+String.format("%.1f", wang.sumSalary()));
		
	}

}

class Employee{
	String  id;
	String 	name;
	double   bSalary;
	double 	salaryUP;
	public Employee(String i,String name,double b){
		this.id=i;
		this.name=name;
		this.bSalary=b;
	}
	
	public double sumSalary(){
		return this.bSalary+this.salaryUP;
	}
	
	public double countSalaryUP(double rate){
		this.salaryUP=this.bSalary*(1+rate);
		return this.salaryUP;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getbSalary() {
		return bSalary;
	}
	public void setbSalary(double bSalary) {
		this.bSalary = bSalary;
	}
	public double getSalaryUP() {
		return salaryUP;
	}
	public void setSalaryUP(double salaryUP) {
		this.salaryUP = salaryUP;
	}
	
}
