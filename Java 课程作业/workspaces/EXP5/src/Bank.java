
/**  
* @Title: Bank.java  
* @Package   
* @Description: TODO  
* @author С��  
* @date 2018��10��12��  
* @version V1.8
*/

/**  
* @ClassName: Bank  
* @Description: TODO
* @author С��  
* @date 2018��10��12��  
*    
*/
public class Bank {
	int savedMoney;
	int year;
	double interest;
	double interestRate = 0.29;
	public double computerInterest() {
		interest = year*interestRate*this.savedMoney;
		return interest;
	}
	public void setInterestRate(double rate) {
		interestRate = rate;
	}
}

