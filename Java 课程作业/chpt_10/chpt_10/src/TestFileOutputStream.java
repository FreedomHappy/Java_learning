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
			
			//�����ļ���
			fis = new FileInputStream(infile);
			fos = new FileOutputStream(outfile,true);
			int i = 0;
			//��ȡ�ļ���
			while((i=fis.read())!=-1)
			{
				fos.write(i);
			}
			//�ر��ļ���
			fis.close();
			fos.close();
		} catch (FileNotFoundException e) {
			System.out.println("�ļ������ڣ�");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("���ݶ�ȡ����");
			e.printStackTrace();
		}
		System.out.println("OK!");
	}
}
