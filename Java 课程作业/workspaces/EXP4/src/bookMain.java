
public class bookMain {

	public static void main(String[] args) {
		book []b=new book[2];
		b[0]=new book("����",100);
		b[1]=new book("���ӵ۹�",200);
		
		for(int i=0; i<b.length; i++){
			System.out.println(b[i].getInfo());
		}
		System.out.println("�ܲ���="+book.getbooknum());
	}

}

class book{
	String 	bookname;
	String 	id;
	double 	price;
	static 	int booknum=0;
	
	book(String name,double price){
		this.bookname=name;
		this.id="ISSN"+booknum;
		this.price=price;
		booknum++;
	}
	
	String getInfo(){
	return "������"+this.bookname+" ��ţ�"+this.id+" �۸�"+this.price;
	}
	
	static int getbooknum(){
		return booknum;
	}
	
}
