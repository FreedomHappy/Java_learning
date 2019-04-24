package 例子01;
import java.io.*;
public class Example10_1 {
	public static String projPath = ".";
    
	public static void main(String args[]) {
		
	  File f = new File("src/例子01/Example10_1.java") ;
//			  +File.separator+"src"
//			  +File.separator
//			  +"例子01" ,"Example10_1.java");
	  
	  
	  System.out.println(f.getName()+"是可读的吗:"+f.canRead());
	  System.out.println(f.getName()+"的长度:"+f.length());
	  System.out.println(f.getName()+"的绝对路径:"+f.getAbsolutePath());
	  File file = new File("new.txt");
	  System.out.println("在当前目录下创建新Filed对象"+file.getAbsolutePath());
      if(!file.exists()) {
         try {
              file.createNewFile();
              System.out.println("创建成功在："+file.getAbsolutePath().substring(0,file.getAbsolutePath().lastIndexOf("\\")));
         }
         catch(IOException exp){}
      }
//      if (file.exists()) {
//
//    	  System.out.println("文件："+file.getAbsolutePath()+"将被删除！");
//    	  file.delete() ;
//    	  
//      }
   }
}
