
/**  
* @Title: check.java  
* @Package   
* @Description: TODO  
* @author:lenovo
* @date 2018��11��16��  
* @version V1.8
*/

/**  
* @ClassName: check  
* @Description: TODO
* @author lenovo  
* @date 2018��11��16��  
*    
*/
public class check {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Machine machine = new Machine();
		String name[]={"ƻ��","ըҩ","����","����","�ֱ�","���"};
		Goods [] goods =new Goods[name.length];
		for(int i=0;i<name.length;i++){
			goods[i]= new Goods();
			if(i%2==0){
				goods[i].setIsDanger(false);
				goods[i].setName(name[i]);
			}
			else{
				goods[i].setIsDanger(true);
				goods[i].setName(name[i]);
			}
		}
		for(int i=0;i<goods.length;i++){
			try{
					machine.checkBag(goods[i]);
					System.out.println(goods[i].getName()+"���ͨ��");
			}
			catch(DangerException e){
				e.toShow();
				System.out.println(goods[i].getName()+"����ֹ��");
			}
		}
	}

}
