
/**  
* @Title: Bank.java  
* @Package   
* @Description: TODO  
* @author 小豪  
* @date 2018年10月12日  
* @version V1.8
*/

/**  
* @ClassName: Bank  
* @Description: TODO
* @author 小豪  
* @date 2018年10月12日  
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

