package banque.domain.exception;

public class InvalidAccountType extends RuntimeException {
	
	public InvalidAccountType() {
		super("Invalid Account Type !");
	}
	
	public InvalidAccountType(String message) {
		super(message);
	}
}