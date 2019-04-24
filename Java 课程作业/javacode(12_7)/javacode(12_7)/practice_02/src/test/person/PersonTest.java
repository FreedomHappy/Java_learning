package test.person;

import org.junit.Test;

import main.pratice_02.door.Door;
import main.pratice_02.door.Door.DOOR_STATE;
import main.pratice_02.door.ElectronicDoor;
import main.pratice_02.person.Admin;
import main.pratice_02.person.Guest;

import static org.junit.Assert.* ;
public class PersonTest {
	
	@Test
	public void testGuest() {
		Guest guest = new Guest("guest_1") ;
		Admin admin = new Admin("admin_1") ;
		Door door = new ElectronicDoor() ;
		guest.ringBell(door);
		admin.openDoorForGuest(door);
		assertEquals(DOOR_STATE.CLOSED, door.getDoorState());
	}
}
