import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ObjectStreamDemo {
	public static String path = "." + File.separator ;

	public static void main(String[] args) throws Exception {
		
		
//		File file = new File(path, "objData")  ;
//		
//		file.createNewFile() ;
//		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file)) ;
//		oos.writeObject(new Stu("张三",19));
//		oos.writeObject(new Stu("李四", 20));
//		oos.flush();
//		oos.close() ;
//		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file)) ;
//		Stu stu = null ;
//		while(true) {
//			Object obj = ois.readObject() ;
//			if (obj instanceof Stu)
//				System.out.println((Stu)obj) ;
//			else {
//				System.out.println(obj);
//				break ;
//			}
//			
//		}
//		ois.close();
		//testBufferedRAndW() ;
		WordStatistic.doProcess(); 
		WordStatistic.printResult();
		

	}
	
	public static void testBufferedRAndW () throws Exception {
		
		Random rand = new Random() ;
		File file = new File(path, "testBuffered.txt") ;
		file.createNewFile() ;
		PrintWriter pw = new PrintWriter(new FileWriter(file)) ;
		int length = rand.nextInt(100) ;
		for (int i=0; i < length ; i++) {
			pw.print(rand.nextInt(100)+", ");
			if (i>10) pw.println();
			
		}
		pw.flush();
		pw.close();
		BufferedReader br = new BufferedReader(new FileReader(file)) ;
		String str = null ;
		
		while ((str=br.readLine())!= null) {
			String[] strs = str.split("\\D+") ;
			for (String s : strs) {
				System.out.println(s) ;
			}
			
		}
		br.close();
		
		
		
		
	}

}


class Stu implements Serializable {

	
	private static final long serialVersionUID = -8582591692485495347L;
	private String name ;
	private int age ;
	
	public Stu(String name, int age) {
		this.age = age ;
		this.name = name ;
	}
	
	@Override
	public String toString() {
		return this.name + ", " + this.age ;
	}
}

class WordStatistic {
	static File file = new File("F:\\teaching\\Lessons\\Java程序设计\\java_workspace\\chpt_10_1\\text.txt") ;
	static Map<String, Integer> wordStat  = new HashMap<String, Integer>() ;
	

	public static void doProcess() throws Exception {
		BufferedReader br = new BufferedReader(new FileReader(file)) ;
		String [] words = null ;
		String str = null ;
		while ((str = br.readLine()) != null) {
			System.out.println(str) ;
			words = str.split("[\\s,\\.]+") ;
			System.out.println("words:" + words.length);
			for (String word : words) {
				System.out.println(word) ;
				if (wordStat.containsKey(word)) {
					wordStat.put(word, wordStat.get(word)+1) ;
				} else {
					wordStat.put(word, 1) ;
				}
				
			}
		}
		br.close() ;
		
	}
	public static void printResult() {
		for (String word : wordStat.keySet()) {
			System.out.println(word + " - >" + wordStat.get(word));
		}
	}
	
	
	
}


