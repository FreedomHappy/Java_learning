
/**  
* @Title: BankOfDalian.java  
* @Package   
* @Description: TODO  
* @author 小豪  
* @date 2018年10月12日  
* @version V1.8
*/

/**  
* @ClassName: BankOfDalian  
* @Description: TODO
* @author 小豪  
* @date 2018年10月12日  
*    
*/
public class BankOfDalian extends Bank {
	double year;
	@Override
	public double computerInterest() {
		super.year = (int)year;
		double r = year-(int)year;
		int day = (int)(r*1000);
		double yearInterest = super.computerInterest();
		double dayInterest = day*0.00012*savedMoney;
		interest = yearInterest + dayInterest;
		System.out.printf("%d元存在大连银行%d年零%d天的利息：%f元\n",
							savedMoney,super.year,day,interest);
		return interest;
	}
}
