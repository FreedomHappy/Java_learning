import java.io.*;
public class TestPrintStream1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String path = "."+File.separator+"files"+File.separator ;
		FileOutputStream fos = null;
		PrintStream ps = null;
		// 确定目的文件 
		File file = new File(path, "test.txt") ;
		
		try {
			// 创建文件
			file.createNewFile() ;
			// 1.确定输出目的
			// 创建文件输出流
			fos = new FileOutputStream(file);
			// 2. 创建具备打印功能的输出流
			ps = new PrintStream(fos,true);
			ps.print("hello");
			for(char c=48; c<127; c++)
			{
				ps.print(c+" ");
			
			}
			ps.flush() ;
		} catch (Exception  e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close() ;
			}catch (Exception e) {
				e.printStackTrace(); 
			}
		}
		System.out.println("OK!");
		

	}

}
