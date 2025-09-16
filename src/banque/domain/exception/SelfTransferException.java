package banque.domain.exception;

public class SelfTransferException extends RuntimeException {
	
	public SelfTransferException() {
		super("Can't transfer money to your self");
	}
	
	public SelfTransferException(String message) {
		super(message);
	}
}