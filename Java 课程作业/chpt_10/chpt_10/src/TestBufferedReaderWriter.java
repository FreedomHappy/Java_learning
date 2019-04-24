/**
 * ���ܣ�����������ɸ�����������Щ��д���ļ����������ȡ��������ն�
 * @author lenovo_GP
 *
 */
import java.io.*;
public class TestBufferedReaderWriter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path = "."+File.separator+"files"+File.separator ;
		
		BufferedWriter bw = null;
		
		BufferedReader br = null;
		File file = new File(path,"random.txt") ;
		//������
		try {
			file.createNewFile() ;
			bw = new BufferedWriter(
					new FileWriter(file));
			
			br = new BufferedReader(
					new FileReader(file));
			// generate test data
			double d = 0.0;
			for(int i=0; i<1000; i++){
				d = Math.random();
				bw.write(String.format("%.2f\n",d));
			}
			bw.flush();
			//��������
			String s = null;
			while((s=br.readLine())!=null) {
				System.out.println(s);
			}
		
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				bw.close();
				br.close();
			}catch (IOException e) {
				e.printStackTrace();
			}

		}
		
		
	}

}
