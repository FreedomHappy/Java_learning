/**
 * 不断从终端获取字符串，存储在文件中，并将其回显在终端
 * @author lenovo_GP
 *
 */
import java.io.*;
import java.util.Date;
public class TestInputStreamReadeWriter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path = "."+File.separator+"files"
					+File.separator ;
		BufferedReader br = new BufferedReader(
				         new InputStreamReader(System.in));
		FileWriter fw = null;
		File file = new File(path, "inputstreamreader.txt") ;
		try {
			fw = new FileWriter(file);
			//BufferedW
			String s = "" ;
			fw.write("====The log for input====");
			while((s=br.readLine())!=null) {
				if(s.equalsIgnoreCase("exit")) break;
				fw.write("\r\n=========\r\n");
				fw.write(s);
				System.out.println(s.toUpperCase());
			}
			fw.write("\r\n==="+new Date()+"===");
		} catch (IOException e) {
			// TODO Auto-generated catch blocek
			e.printStackTrace();
		} finally {
			try {
				br.close();
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}
