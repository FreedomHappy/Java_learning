package chpt_06;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter.DEFAULT;

public class InterfaceDemo {

	public static void main(String[] args) {

		
		B b = new B() ;
		b.defaultMethod(); 
		b.method(); 
		b.method1(); 
		b.method2();
	}

}

interface InterfaceExample {
	
	public static final String CONSTANT = "hello" ;
	
	void method() ;
	public abstract void method1() ;
	/**
	 * 
	 * @function 给予足够的注释
	 */
	public default void method2() {
		System.out.println("this is default method method2() in interface ");
		
	}
	/**
	 * 
	 * @function 这是一个缺省方法
	 */
	public default void defaultMethod() {
		System.out.println("this is defaultmethod() in interface ");
		
	}
	
	public static void staticMethod() {
		
	}
	
}

abstract class A implements InterfaceExample {

	@Override
	public void method() {
		System.out.println("this is method() in A ");
		
	}
	

	
	
}

class B extends A {

	@Override
	public void method1() {
		System.out.println("this is method1() in B ");
		
	}
	@Override
	public void method() {
		System.out.println("this is method() overrided in B ");
		
	}
	
}

