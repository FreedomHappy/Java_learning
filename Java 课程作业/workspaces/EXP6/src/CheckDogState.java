
/**  
* @Title: CheckDogState.java  
* @Package   
* @Description: ����С���ĸ���״̬
* @author lin  
* @date 2018��10��19��  
* @version V1.8
*/


interface DogState{
	public void showState();
}
class SoftlyState implements DogState{
	public void showState(){
		System.out.println("�����˵�����");
	}
}

class MeetEnemyState implements DogState{
	public void showState(){
		System.out.println("��У�������ȥ��ҧ����");
	}
}
class MeetFriendState implements DogState{
	public void showState(){
		System.out.println("�ζ�β�ͣ���ʾ��ӭ");
	}
}
class MeetAnotherDog implements DogState{
	public void showState(){
		System.out.println("��Ϸ");
	}
}

class Dog{
	DogState state;
	public void show(){
		state.showState();
	}
	public void setState(DogState s){
		state = s;
	}
}

/**  
* @ClassName: CheckDogState  
* @Description: ����С���ĸ���״̬
* @author lin  
* @date 2018��10��19��  
*    
*/
public class CheckDogState {

	public static void main(String[] args) {
		Dog yellowDog = new Dog();
		System.out.print("����������ǰ��");
		yellowDog.setState(new SoftlyState());
		yellowDog.show();
		System.out.print("���������ˣ�");
		yellowDog.setState(new MeetEnemyState());
		yellowDog.show();
		System.out.print("���������ѣ�");
		yellowDog.setState(new MeetFriendState());
		yellowDog.show();
		System.out.print("������ͬ�飺");
		yellowDog.setState(new MeetAnotherDog());
		yellowDog.show();
	}

}
