import java.io.*;

public class TestDataOutputStream {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		File target = null ;
		FileOutputStream fos = null;
		//BufferedOutputStream bos = null;
		DataOutputStream dos = null;
		//InputStreamReader isr = null;
	
		try {
			target = new File("files" + File.separator + "dataOutput.txt") ;
			if (!target.exists()){
				target.createNewFile();
			}
			fos = new FileOutputStream(target,true);
			dos = new DataOutputStream(fos);
			//dos = new BufferedOutputStream(bos);
			BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		
			String  s = br.readLine();
			while((s=br.readLine())!=null)
				dos.writeBytes(s);
			
			dos.close();
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
