import java.io.*;
public class TestStreamWriter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileOutputStream fos = null;
		FileInputStream fis = null;
		DataInputStream dis = null;
		FileWriter fw = null;
		DataOutputStream dos = null;
		int i=10;
		
		try {
			fos = new FileOutputStream("f:\\javacodes\\testdata\\outstream.txt");
			fis = new FileInputStream("f:\\javacodes\\testdata\\outstream.txt");
			fw = new FileWriter("f:\\javacodes\\testdata\\writer.txt");
			dos = new DataOutputStream(fos);
			dis = new DataInputStream(fis);
			fw.write(String.valueOf(i).toCharArray());
			fw.flush();
			dos.writeInt(i);
			System.out.println(dos.size());
			dos.flush();	
			int j = dis.readInt();
			System.out.println(j);
			fw.close();
			dos.close();
			fos.close();
		} catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
