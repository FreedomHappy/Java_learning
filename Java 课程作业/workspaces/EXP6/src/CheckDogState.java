
/**  
* @Title: CheckDogState.java  
* @Package   
* @Description: 测试小狗的各种状态
* @author lin  
* @date 2018年10月19日  
* @version V1.8
*/


interface DogState{
	public void showState();
}
class SoftlyState implements DogState{
	public void showState(){
		System.out.println("听主人的命令");
	}
}

class MeetEnemyState implements DogState{
	public void showState(){
		System.out.println("狂叫，并冲上去狠咬敌人");
	}
}
class MeetFriendState implements DogState{
	public void showState(){
		System.out.println("晃动尾巴，表示欢迎");
	}
}
class MeetAnotherDog implements DogState{
	public void showState(){
		System.out.println("嬉戏");
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
* @Description: 测试小狗的各种状态
* @author lin  
* @date 2018年10月19日  
*    
*/
public class CheckDogState {

	public static void main(String[] args) {
		Dog yellowDog = new Dog();
		System.out.print("狗在主人面前：");
		yellowDog.setState(new SoftlyState());
		yellowDog.show();
		System.out.print("狗遇到敌人：");
		yellowDog.setState(new MeetEnemyState());
		yellowDog.show();
		System.out.print("狗遇到朋友：");
		yellowDog.setState(new MeetFriendState());
		yellowDog.show();
		System.out.print("狗遇到同伴：");
		yellowDog.setState(new MeetAnotherDog());
		yellowDog.show();
	}

}
