package test.door;

import org.junit.Test;

import main.pratice_02.validator.Computer;
import main.pratice_02.validator.PassValidator;
import main.pratice_02.validator.Validator;
import static org.junit.Assert.* ;

public class ValidatorTest {

	
	@Test
	public void testPassValidator () {
		Computer computer = new Computer(new String[] {"pa123","pa456"}) ;
		Validator pass = new PassValidator(computer) ;
		assertEquals(false, pass.inputAndValide());
	}
}
