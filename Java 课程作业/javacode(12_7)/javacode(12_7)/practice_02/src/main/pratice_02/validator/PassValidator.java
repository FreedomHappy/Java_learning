package main.pratice_02.validator;

public class PassValidator extends ComputerValidator {

	public PassValidator(Computer computer) {
		super(computer);
	}

	@Override
	public boolean inputAndValide() {
		return this.computer.existed(inputMsg("PASS")) ;
	}

}
