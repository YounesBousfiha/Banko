package banque.domain.exception;

public class InvalidAccountNaming extends RuntimeException {
	
	public InvalidAccountNaming() {
		super("Invalid Account Naming Convention !");
	}
	
	public InvalidAccountNaming(String message) {
		super(message);
	}
}