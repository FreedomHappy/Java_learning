
/**  
* @Title: DangerException.java  
* @Package   
* @Description: TODO  
* @author:lenovo
* @date 2018年11月16日  
* @version V1.8
*/

/**  
* @ClassName: DangerException  
* @Description: TODO
* @author lenovo  
* @date 2018年11月16日  
*    
*/
public class DangerException extends Exception{
	private String message;
	public DangerException(){
		message = "危险品！";
	}
	public void toShow(){
		System.out.println(message+" ");
	}
}
