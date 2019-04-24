package main.pratice_02.person;

import main.pratice_02.door.Door;

/**
 *
 * 
 * @author Ping
 * @date 2018��12��4��
 */
public class Employee extends Guest {
	
	public Employee() {
		
	}
	public Employee(String name) {
		super(name) ;
	}
	
	@Override
	public String toString() {
		return "EMPLOYEE "
				+ this.name ;
	}
	public void openDoor(Door door) {
		door.open(this);
	}

}
