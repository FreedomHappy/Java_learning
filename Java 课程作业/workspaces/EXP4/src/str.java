
public class str {

	public static void main(String[] args) {
		//(1)
		String str = "Java����ѧϰ��20070326";
		System.out.println("��������:"+str.split("��")[1]);
		//(2)
		str="MLDN JAVA";
		System.out.println("�滻ΪJ2EE:"+str.replaceAll("JAVA","J2EE"));
		//(3)
		str="Java����ѧϰ��20070326";
		System.out.println("��8���ַ�:"+str.charAt(7));
		//(4)
		System.out.println("�������0:"+str.replaceAll("0", ""));
		//(5)
		str="Java ����ѧϰ�� 20070326 MLDN ��ʦ";
		System.out.println("������пո�:"+str.replaceAll(" ", ""));
		//(6)
		str="350600199811224010";
		System.out.println(str.substring(6,14));
	}

}
