
/**  
* @Title: DangerException.java  
* @Package   
* @Description: TODO  
* @author:lenovo
* @date 2018��11��16��  
* @version V1.8
*/

/**  
* @ClassName: DangerException  
* @Description: TODO
* @author lenovo  
* @date 2018��11��16��  
*    
*/
public class DangerException extends Exception{
	private String message;
	public DangerException(){
		message = "Σ��Ʒ��";
	}
	public void toShow(){
		System.out.println(message+" ");
	}
}
