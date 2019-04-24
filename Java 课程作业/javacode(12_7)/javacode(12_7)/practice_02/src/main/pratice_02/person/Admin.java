package main.pratice_02.person;

import main.pratice_02.door.Door;

/**
 * the base class for all kinds of person in course .
 * 
 * @author Ping
 * @date 2018Äê12ÔÂ4ÈÕ
 */
public class Admin extends Employee {
	private String name ;
	
	public Admin() {
		
	}
	public Admin(String name) {
		this.name = name ;
	}
	
	@Override
	public String toString() {
		return "ADMIN "
				+ this.name ;
	}
	public void openDoorForGuest(Door door) {
		if (door.isRing()) {
			door.open(this);
		}
	}

}
