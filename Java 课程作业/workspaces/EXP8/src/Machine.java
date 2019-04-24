
/**  
* @Title: Machine.java  
* @Package   
* @Description: TODO  
* @author:lenovo
* @date 2018年11月16日  
* @version V1.8
*/

/**  
* @ClassName: Machine  
* @Description: TODO
* @author lenovo  
* @date 2018年11月16日  
*    
*/
public class Machine {
	public void checkBag(Goods goods) throws DangerException{
		if(goods.isDanger()){
			DangerException danger =new DangerException();
			throw danger;
		}
		else{
			System.out.println(goods.getName()+"不是危险品");
		}
	}
}
