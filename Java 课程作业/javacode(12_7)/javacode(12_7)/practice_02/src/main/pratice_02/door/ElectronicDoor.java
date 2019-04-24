package main.pratice_02.door;





import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import main.pratice_02.person.Admin;
import main.pratice_02.person.Employee;
import main.pratice_02.person.Guest;
import main.pratice_02.validator.Validator;

public class ElectronicDoor extends Door {
	private static final Logger logger = LogManager.getLogger(ElectronicDoor.class) ;
	private Validator validator ;
	
	public ElectronicDoor() {
	}
	public ElectronicDoor(Validator validator) {
		super();
		this.validator = validator ;
	}

	@Override
	public void open(Guest guest) {
		if (guest instanceof Admin) {
			this.doorState = DOOR_STATE.OPEN ;
			logger.info(" the door was open by {}", (Admin)guest);
			return ;
		}
		if (guest instanceof Employee) {
			if (validator.inputAndValide()) {
				logger.info(" Welcome {} ", guest);
			} else {
				logger.info(" Sorry, you failed in validation .");
			}
		} else {
			logger.info(" hi, guest, you are not allowed to open door, and please ring the door bell.");
		}
		
	}
	
	

}
