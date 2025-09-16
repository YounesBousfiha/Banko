package banque.domain.exception;

public class DuplicateAccount extends RuntimeException {
	
	public DuplicateAccount() {
		super("Duplicate Account Code");
	}
	
	public DuplicateAccount(String message) {
		super(message);
	}
}