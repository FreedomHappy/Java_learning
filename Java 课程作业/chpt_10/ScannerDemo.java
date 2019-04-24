package chpt_10;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class ScannerDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static void textByBufferedReader() throws IOException {
		
		File file = new File("src/chpt_10/score.txt") ;
		File target = new File("src/chpt_10/newScore.txt") ;
		
		if (!target.exists()) {
			target.createNewFile() ;
		}
		
		BufferedReader reader = new BufferedReader(new FileReader(file)) ;
		PrintWriter writer = new PrintWriter(target) ;
		String line = null; 
		
		while ((line = reader.readLine()) != null ) {
			// split
			
			// sum 
			
			// append
			
			// write 
			
			
		}
 		
		
 		
		
		
		
		
		
		
	}
	

}
