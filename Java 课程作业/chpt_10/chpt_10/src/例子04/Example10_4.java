package ����04;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import ����01.Example10_1;
public class Example10_4 {
   public static void main(String args[]) {
      int n=-1;
      byte [] a=new byte[1024];
      FileInputStream in = null ;
      try{  
    	  // 1. ȷ��Դͷ
    	  File f=new File(Example10_1.projPath
    			  +"/src/����04","Example10_4.java");
    	  // 2. �����������ܵ�
    	 in = new FileInputStream(f);
    	  // 3. ��ȡ����
            while((n=in.read(a))!=-1) {
            /*	
             * String  ---> byte[]  : byte[] getBytes() 
             * byte[]   --> String   �� new String (byte[])
             */
              String s=new String (a,0,n);
              System.out.print(s);
           //   System.out.println(n); 
            }
      }
      catch(IOException e) {
           System.out.println("File read Error"+e);
      } finally {
    	// �ر�������
    	  try {
    		  in.close();
    	  } catch (IOException e) {
    		 e.printStackTrace();
    	  }
      }
   }
}


