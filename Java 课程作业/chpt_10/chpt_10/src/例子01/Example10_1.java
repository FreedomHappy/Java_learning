package ����01;
import java.io.*;
public class Example10_1 {
	public static String projPath = ".";
    
	public static void main(String args[]) {
		
	  File f = new File("src/����01/Example10_1.java") ;
//			  +File.separator+"src"
//			  +File.separator
//			  +"����01" ,"Example10_1.java");
	  
	  
	  System.out.println(f.getName()+"�ǿɶ�����:"+f.canRead());
	  System.out.println(f.getName()+"�ĳ���:"+f.length());
	  System.out.println(f.getName()+"�ľ���·��:"+f.getAbsolutePath());
	  File file = new File("new.txt");
	  System.out.println("�ڵ�ǰĿ¼�´�����Filed����"+file.getAbsolutePath());
      if(!file.exists()) {
         try {
              file.createNewFile();
              System.out.println("�����ɹ��ڣ�"+file.getAbsolutePath().substring(0,file.getAbsolutePath().lastIndexOf("\\")));
         }
         catch(IOException exp){}
      }
//      if (file.exists()) {
//
//    	  System.out.println("�ļ���"+file.getAbsolutePath()+"����ɾ����");
//    	  file.delete() ;
//    	  
//      }
   }
}
