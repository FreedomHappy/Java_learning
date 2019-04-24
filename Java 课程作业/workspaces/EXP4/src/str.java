
public class str {

	public static void main(String[] args) {
		//(1)
		String str = "Java技术学习班20070326";
		System.out.println("开班日期:"+str.split("班")[1]);
		//(2)
		str="MLDN JAVA";
		System.out.println("替换为J2EE:"+str.replaceAll("JAVA","J2EE"));
		//(3)
		str="Java技术学习班20070326";
		System.out.println("第8个字符:"+str.charAt(7));
		//(4)
		System.out.println("清除所有0:"+str.replaceAll("0", ""));
		//(5)
		str="Java 技术学习班 20070326 MLDN 老师";
		System.out.println("清除所有空格:"+str.replaceAll(" ", ""));
		//(6)
		str="350600199811224010";
		System.out.println(str.substring(6,14));
	}

}
