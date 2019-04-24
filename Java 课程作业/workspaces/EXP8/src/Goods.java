import com.sun.org.apache.bcel.internal.generic.ReturnaddressType;

/**  
* @Title: Goods.java  
* @Package   
* @Description: TODO  
* @author:lenovo
* @date 2018年11月16日  
* @version V1.8
*/

/**  
* @ClassName: Goods  
* @Description: TODO
* @author lenovo  
* @date 2018年11月16日  
*    
*/
public class Goods {
	private boolean isDanger;
	private String name;
	public void setIsDanger(boolean boo){
		this.isDanger=boo;
	}
	public boolean isDanger(){
		return this.isDanger;
	}
	public void setName(String s){
		name=s;
	}
	public String getName(){
		return this.name;
	}
	
}
