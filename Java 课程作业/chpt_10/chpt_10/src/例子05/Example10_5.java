package ����05;
import java.io.*;

import ����01.Example10_1;
public class Example10_5 {
   public static void main(String args[]) {
      byte [] a = "�������".getBytes();
      byte [] b = "Happy New Year".getBytes();
      File file = new File("./src"+"/����05/","a.txt");                         //�����Ŀ�ĵ�
      try{  
    	 if (!file.exists()) {
    		 file.createNewFile() ;
    	 }
         //ָ��Ŀ�ĵص������
         OutputStream out=new FileOutputStream(file);     
         System.out.println(file.getName()+"�Ĵ�С:"
               +file.length()+"�ֽ�");//a.txt�Ĵ�С:0�ֽ�
         out.write(a);
                                   //��Ŀ�ĵ�д����
         out.flush(); 
         out.close();
         //׼�����ļ�β������
         out=new FileOutputStream(file,true);            
         System.out.println(file.getName()+"�Ĵ�С:"+file.length()+"�ֽ�");///a.txt�Ĵ�С:8�ֽ�
         out.write(b,0,b.length); 
         System.out.println(file.getName()+"�Ĵ�С:"+file.length()+"�ֽ�");///a.txt�Ĵ�С:8�ֽ�
         out.close();
      }
      catch(IOException e) {
          System.out.println("Error "+e);
      }
  }
}
