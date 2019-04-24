package ??02;
import java.io.*;
public class Example10_2 {
   public static void main(String args[]) {
      File dirFile = new File("src/??01");
//      FileAccept fileAccept = new FileAccept();
//      fileAccept.setExtendName("java");
     // String fileName[] = dirFile.list(fileAccept);
      
      String[] fileName = dirFile.list(new FilenameFilter() {
		
		@Override
		public boolean accept(File dir, String name) {
			// TODO Auto-generated method stub
			return name.endsWith("java");
		}
	} );
      
      
      for(String name:fileName) {
          System.out.println(name);
      }
   }
}
