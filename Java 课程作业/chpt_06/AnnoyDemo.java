package chpt_06;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AnnoyDemo {

	public static void main(String[] args) {
//		List<Stu> stuList = new ArrayList<Stu>() ;
//		
//		stuList.add(new Stu("005", "zhangsan",18)) ;
//		stuList.add(new Stu("003", "zhangsan1",28)) ;
//		stuList.add(new Stu("004", "zhangsan2",38)) ;
//		stuList.add(new Stu("001", "zhangsan3",22)) ;
//		
//		Collections.sort(stuList) ; 
//		for (Stu stu : stuList) {
//			System.out.println(stu);
//		}
//		// using annoymous inner class to define a new order, 
//		// and the order can only be used one time 
//		Collections.sort(stuList, 
//				new Comparator<Stu>() {
//			// body of inner class
//			@Override
//			public int compare(Stu o1, Stu o2) {
//				// based on stu age  to define a new order
//				if (o1.age > o2.age ) return 1 ;
//				if (o1.age < o2.age ) return -1 ;
//				return 0;
//			}
//			
//		});
//		System.out.println("----------sorted by age-------------");
//		for (Stu stu : stuList) {
//			System.out.println(stu);
//		}
		// example for annoy-inner class of abstract class
		
		Num num = new Num(4) {
			@Override
			public int getValue() {
				// TODO Auto-generated method stub
				return this.value;
			}
			
		} ;
		System.out.println(num.getValue());
		
		
	}

}


abstract class Num {
	int value ;
	public Num() {} 
	public Num(int value) {
		this.value = value ;
	}

	public abstract int getValue() ;
	

}


class Stu implements Comparable<Stu> { // Comparable<T>
	
	String id ;
	String name ;
	int age ;
	
	public Stu() {
		
	}
	public Stu(String id, String name, int age) {
		this.id = id ;
		this.name = name ;
		this.age = age ; 
	}
	
	@Override
	public boolean equals(Object o) {
		
		if (o instanceof Stu) {
			Stu stu = (Stu) o ;
			return this.id.equals(stu.id) && this.name.equals(stu.name) ;
		}
		return false ;
	}
	
	@Override
	public int hashCode() {
		return this.id.hashCode()  ;
	}
	
	@Override
	public int compareTo(Stu o) {
		// define an order for this and o objects
		// based on student id 
		return this.id.compareTo(o.id) ;
	}
	
	@Override 
	public String toString() {
		return this.id + ", " + this.name + ", " + this.age ;
	}
	
	
	
}
