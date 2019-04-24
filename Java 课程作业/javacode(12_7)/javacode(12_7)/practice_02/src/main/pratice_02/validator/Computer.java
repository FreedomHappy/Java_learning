package main.pratice_02.validator;

public class Computer {
	private String[] pwds ;
	
	public Computer(String[] pwds) {
		this.pwds = pwds ;
	}
	
	public boolean existed(String pwd) {
		for (String pd : pwds) {
			if (pd.equals(pwd)) return true ;
		}
		return false ;
	}

}
