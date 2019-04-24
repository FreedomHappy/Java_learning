
public class bookMain {

	public static void main(String[] args) {
		book []b=new book[2];
		b[0]=new book("三体",100);
		b[1]=new book("银河帝国",200);
		
		for(int i=0; i<b.length; i++){
			System.out.println(b[i].getInfo());
		}
		System.out.println("总册数="+book.getbooknum());
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
	return "书名："+this.bookname+" 编号："+this.id+" 价格："+this.price;
	}
	
	static int getbooknum(){
		return booknum;
	}
	
}
