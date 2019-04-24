

/**  
* @Title: scoreAnalysis.java  
* @Package   
* @Description: TODO  
* @author:小豪
* @date 2018年12月14日  
* @version V1.8
*/

/**  
* @ClassName: scoreAnalysis  
* @Description: TODO
* @author 小豪  
* @date 2018年12月14日  
*    
*/
import java.io.*;
public class ScoreAnalysis {
	public static void main(String args[]) {
		scoreAna();
	}
	public static void scoreAna() {
		File scoreFile = null;
		File anaFile = null;
		BufferedReader in = null;
		PrintWriter out = null;
		String line;
		try {
			scoreFile = new File("./src/score.txt");
			anaFile = new File("./src/scoreAnalysis.txt");
			if(!anaFile.exists()) {
		         try {
		              anaFile.createNewFile();
		              System.out.println("创建成功在："+anaFile.getAbsolutePath().substring(0,anaFile.getAbsolutePath().lastIndexOf("\\")));
		         }
		         catch(IOException exp){}
		      }
			
			out = new PrintWriter(anaFile);
			in = new BufferedReader(new FileReader(scoreFile));
			String regex = "\\D+";
			int sum=0;
			
			while((line=in.readLine())!=null) {
				// regex parse
				String tokens[] = line.split(regex);
				// calculate score sum
				for (String token : tokens){
					if(!"".equals(token)){
						
						sum += Integer.parseInt(token);
					}
				}
				// write
				StringBuffer sb = new StringBuffer(line);
				out.println(sb.append(" 总分：").append(sum).toString());
				sum = 0;
			}
			
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				in.close();
				out.flush();
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
