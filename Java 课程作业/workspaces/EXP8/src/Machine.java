
/**  
* @Title: Machine.java  
* @Package   
* @Description: TODO  
* @author:lenovo
* @date 2018��11��16��  
* @version V1.8
*/

/**  
* @ClassName: Machine  
* @Description: TODO
* @author lenovo  
* @date 2018��11��16��  
*    
*/
public class Machine {
	public void checkBag(Goods goods) throws DangerException{
		if(goods.isDanger()){
			DangerException danger =new DangerException();
			throw danger;
		}
		else{
			System.out.println(goods.getName()+"����Σ��Ʒ");
		}
	}
}
