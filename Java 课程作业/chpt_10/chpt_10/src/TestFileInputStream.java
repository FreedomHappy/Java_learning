import java.io.*;

public class TestFileInputStream {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileInputStream fis = null;
		
		String path="."+File.separator+"src"+File.separator ;
		File file = new File(path,"TestFileInputStream.java") ;
		try {
			//创建文件流
			
			byte[] data = new byte[(int)file.length()] ;
			fis = new FileInputStream(new File(path,"TestFileInputStream.java"));
			int i = 0;
			
			//读取文件流

			for (int j=0; (i=fis.read())!=-1; j++) {
				data[j] = (byte)i ;
			}
			System.out.println(new String(data,"GBK")) ;
			//关闭文件流
			fis.close();
		} catch (FileNotFoundException e) {
			System.out.println("文件不存在！");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("数据读取错误！");
			e.printStackTrace();
		}
		
	}

}
