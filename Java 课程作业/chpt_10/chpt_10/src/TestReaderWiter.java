/**
 * ���ܣ���һ�ַ���д��ĳ�ļ����ڴӸ��ļ��ж�ȡ���ַ�������ʾ���ն�
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
			String s = "���idnvijdsijvsjdjvidjdfij";
			int c = 0;
			//д��
			fw.write(s);
			fw.flush();
			//���벢���
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
