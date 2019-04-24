
/**  
* @Title: countWord.java  
* @Package   
* @Description: TODO  
* @author:小豪
* @date 2018年12月14日  
* @version V1.8
*/


import java.io.*;
import java.nio.MappedByteBuffer;
import java.util.*;
import java.util.Map.Entry;

import com.sun.jndi.url.iiopname.iiopnameURLContextFactory;

/**  
* @ClassName: countWord  
* @Description: TODO
* @author 小豪  
* @date 2018年12月14日  
*    
*/
public class CountWord {
	public static void main(String args[]) {
		countWord();
	}
	public static void countWord() {
		try {
			File wordFile = new File("./src/toyText.txt");
			String regex = "\\s+|\\.|\\,";
			Scanner sc = new Scanner(wordFile);
			sc.useDelimiter(regex);
			Map<String,Integer> map = new TreeMap<String,Integer>();
			int sumWords = 0;
			int sumDiffWords = 0;
			String word = null;
			while(sc.hasNext()) {
				word = sc.next();
				if("".equals(word)) {
					continue;
				}
				sumWords++;
				// 更新map
				if(map.containsKey(word)) {
					map.put(word, map.get(word)+1);
				}
				else {
					map.put(word, 1);
					sumDiffWords++;
				}
			}
			
			//这里将map.entrySet()转换成list
		    List<Map.Entry<String,Integer>> list = null;
		    list = new ArrayList<Map.Entry<String,Integer>>(map.entrySet());
		    //然后通过比较器来实现排序
		    Collections.sort(list,new Comparator<Map.Entry<String,Integer>>() {
	            //升序排序
	            public int compare(Entry<String, Integer> o1,
	                    Entry<String, Integer> o2) {
	                return o1.getValue().compareTo(o2.getValue());
	            }
	        });
		    //降序
		    Collections.reverse(list);	
		    //输出
		    System.out.println("单词总数："+sumWords);
		    System.out.println("不同单词总数："+sumDiffWords);
		    for(Map.Entry<String,Integer> mapping:list){ 
	               System.out.println(mapping.getKey()+":"+mapping.getValue()); 
	          }
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
