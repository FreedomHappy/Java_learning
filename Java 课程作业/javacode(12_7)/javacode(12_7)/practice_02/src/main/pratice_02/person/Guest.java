package main.pratice_02.person;

import main.pratice_02.door.Door;

/**
 * the base class for all kinds of person in course .
 * 
 * @author Ping
 * @date 2018Äê12ÔÂ4ÈÕ
 */
public class Guest {
	protected String name ;
	
	public Guest() {
		
	}
	public Guest(String name) {
		this.name = name ;
	}
	
	@Override
	public String toString() {
		return "GUEST "
				+ this.name ;
	}
	public void ringBell(Door door) {
		door.ringBell(); 
	}

}
