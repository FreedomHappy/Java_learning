
/**  
* @Title: Example.java  
* @Package   
* @Description: TODO  
* @author С��  
* @date 2018��10��12��  
* @version V1.8
*/

/**  
* @ClassName: Example  
* @Description: TODO
* @author С��  
* @date 2018��10��12��  
*    
*/
public class Example {


	public static void main(String[] args) {
		ChinaPeople chinaPeople = new ChinaPeople();
		AmericanPeople americanPeople = new AmericanPeople();
		BeijingPeople beijingPeople = new BeijingPeople();
		chinaPeople.speakHello();
		americanPeople.speakHello();
		beijingPeople.speakHello();
		chinaPeople.averageHeight();
		americanPeople.averageHeight();
		beijingPeople.averageHeight();
		chinaPeople.averageWeight();
		americanPeople.averageWeight();
		beijingPeople.averageWeight();
		chinaPeople.chinaGongfu();
		americanPeople.americanBoxing();
		beijingPeople.beijingOpera();
		beijingPeople.chinaGongfu();	
	}

}
