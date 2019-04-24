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
			//�����ļ���
			
			byte[] data = new byte[(int)file.length()] ;
			fis = new FileInputStream(new File(path,"TestFileInputStream.java"));
			int i = 0;
			
			//��ȡ�ļ���

			for (int j=0; (i=fis.read())!=-1; j++) {
				data[j] = (byte)i ;
			}
			System.out.println(new String(data,"GBK")) ;
			//�ر��ļ���
			fis.close();
		} catch (FileNotFoundException e) {
			System.out.println("�ļ������ڣ�");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("���ݶ�ȡ����");
			e.printStackTrace();
		}
		
	}

}
