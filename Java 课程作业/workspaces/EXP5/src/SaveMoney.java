
/**  
* @Title: SaveMoney.java  
* @Package   
* @Description: TODO  
* @author С��  
* @date 2018��10��12��  
* @version V1.8
*/

/**  
* @ClassName: SaveMoney  
* @Description: TODO
* @author С��  
* @date 2018��10��12��  
*    
*/
public class SaveMoney {

	public static void main(String[] args) {
		int amount = 8000;
		ConstructionBank bank1 = new ConstructionBank();
		bank1.savedMoney = amount;
		bank1.year = 8.236;
		bank1.setInterestRate(0.035);
		double interest1 = bank1.computerInterest();
		BankOfDalian bank2 = new BankOfDalian();
		bank2.savedMoney = amount;
		bank2.year = 8.236;
		bank2.setInterestRate(0.035);
		double interest2 = bank2.computerInterest();
		System.out.printf("����������Ϣ���%fԪ\n",interest2-interest1);

	}

}
