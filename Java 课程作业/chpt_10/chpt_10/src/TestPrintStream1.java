import java.io.*;
public class TestPrintStream1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String path = "."+File.separator+"files"+File.separator ;
		FileOutputStream fos = null;
		PrintStream ps = null;
		// ȷ��Ŀ���ļ� 
		File file = new File(path, "test.txt") ;
		
		try {
			// �����ļ�
			file.createNewFile() ;
			// 1.ȷ�����Ŀ��
			// �����ļ������
			fos = new FileOutputStream(file);
			// 2. �����߱���ӡ���ܵ������
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
