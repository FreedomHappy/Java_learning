
/**  
* @Title: test.java  
* @Package   
* @Description: TODO  
* @author:С��
* @date 2018��11��10��  
* @version V1.8
*/

/**  
* @ClassName: test  
* @Description: TODO
* @author С��  
* @date 2018��11��10��  
*    
*/
public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		B b =new B("dsds");
		b.Outname();
	}
	

}
class A{
	public A(String name) {this.name=name;}
	private String name;
	public String getName() {
		return this.name;
	}
}

class B extends A{
	public B(String name){super(name);}
	public void Outname() {
		System.out.println(super.getName());
	}
}

