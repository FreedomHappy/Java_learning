/**
 * 功能：将一字符串写入某文件，在从该文件中读取该字符串并显示在终端
 * @author lenovo_GP
 *
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
public class TestReaderWiter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path = "."+File.separator+"files"+File.separator ;
		FileWriter fw = null;
		FileReader fr = null;
		File file = new File(path,"test.txt") ;
		FileInputStream fis = null ;
		
		
		try {
			
			//file.createNewFile() ;
			
			fw = new FileWriter(file);
			fr = new FileReader(file);
			fis = new FileInputStream(file) ;
			String s = "你好idnvijdsijvsjdjvidjdfij";
			int c = 0;
			//写入
			fw.write(s);
			fw.flush();
			//读入并输出
			while((c=fr.read())!=-1) {	
				System.out.print((char)c);
			}
			System.out.println() ;
			
			byte[] b = new byte[100] ;
			int readNum = 0 ;
			while(( readNum = fis.read(b))!= -1) {
				System.out.println(new String(b, 0, readNum)) ;
			}
			
			
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				fw.close();
				fr.close();
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
	}

}
