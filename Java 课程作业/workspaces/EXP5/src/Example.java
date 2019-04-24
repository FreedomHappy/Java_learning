
/**  
* @Title: Example.java  
* @Package   
* @Description: TODO  
* @author 小豪  
* @date 2018年10月12日  
* @version V1.8
*/

/**  
* @ClassName: Example  
* @Description: TODO
* @author 小豪  
* @date 2018年10月12日  
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
