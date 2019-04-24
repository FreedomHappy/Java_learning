import java.io.*;
public class TestFileOutputStream {

	public static void main(String[] args)
	{
		String path="."+File.separator+"src"+File.separator ;
		FileInputStream fis = null;
		FileOutputStream fos = null;
		File infile = new File(path,"TestFileInputStream.java") ;
		File outfile = new File(path, "Output.java") ;
	
		
		
		try {
			
			if (outfile.exists()) {
				outfile.delete() ;
				outfile.createNewFile() ;
			}
			
			//创建文件流
			fis = new FileInputStream(infile);
			fos = new FileOutputStream(outfile,true);
			int i = 0;
			//读取文件流
			while((i=fis.read())!=-1)
			{
				fos.write(i);
			}
			//关闭文件流
			fis.close();
			fos.close();
		} catch (FileNotFoundException e) {
			System.out.println("文件不存在！");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("数据读取错误！");
			e.printStackTrace();
		}
		System.out.println("OK!");
	}
}
