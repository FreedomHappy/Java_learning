
/**  
* @Title: BeijingPeople.java  
* @Package   
* @Description: TODO  
* @author С��  
* @date 2018��10��12��  
* @version V1.8
*/

/**  
* @ClassName: BeijingPeople  
* @Description: TODO
* @author С��  
* @date 2018��10��12��  
*    
*/
public class BeijingPeople extends ChinaPeople {
	@Override
	public void averageHeight() {
		height = 172.5;
		System.out.println("�����˵�ƽ����ߣ�"+height+"����");
	}
	@Override
	public void averageWeight() {
		weight = 70;
		System.out.println("�����˵�ƽ�����أ�"+weight+"ǧ��");
	}
	public void beijingOpera() {
		System.out.println("���������¡�����������");
	}
}
