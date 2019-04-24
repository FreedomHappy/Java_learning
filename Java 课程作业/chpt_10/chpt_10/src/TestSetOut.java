import java.io.*;

public class TestSetOut {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileOutputStream fos = null;
		
		try {
			fos = new FileOutputStream("f:\\javacodes\\testdata\\testsetout.txt");
			PrintStream ps = new PrintStream(fos);
			
			System.setOut(ps);
			System.out.println("mircosoftIBMJavaTM");
			
			fos.close();
			ps.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
