
/**  
* @Title: AmericanPeople.java  
* @Package   
* @Description: TODO  
* @author С��  
* @date 2018��10��12��  
* @version V1.8
*/

/**  
* @ClassName: AmericanPeople  
* @Description: TODO
* @author С��  
* @date 2018��10��12��  
*    
*/
public class AmericanPeople extends People{
	@Override
	public void speakHello() {
		System.out.println("How do you do");
	}
	@Override
	public void averageHeight() {
		height = 176;
		System.out.println("American's average height:"+height+" cm");
	}
	@Override
	public void averageWeight() {
		weight = 75;
		System.out.println("American's average height:"+weight+" kg");
	}
	public void americanBoxing() {
		System.out.println("ֱȭ����ȭ�����ȭ");
	}
}
