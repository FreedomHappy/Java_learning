
/**  
* @Title: BeijingPeople.java  
* @Package   
* @Description: TODO  
* @author 小豪  
* @date 2018年10月12日  
* @version V1.8
*/

/**  
* @ClassName: BeijingPeople  
* @Description: TODO
* @author 小豪  
* @date 2018年10月12日  
*    
*/
public class BeijingPeople extends ChinaPeople {
	@Override
	public void averageHeight() {
		height = 172.5;
		System.out.println("北京人的平均身高："+height+"厘米");
	}
	@Override
	public void averageWeight() {
		weight = 70;
		System.out.println("北京人的平均体重："+weight+"千克");
	}
	public void beijingOpera() {
		System.out.println("花脸、青衣、花旦和老生");
	}
}
