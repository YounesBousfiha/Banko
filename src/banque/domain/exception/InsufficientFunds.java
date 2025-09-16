package banque.domain.exception;

public class InsufficientFunds extends RuntimeException {
	
	public InsufficientFunds() {
		super("Insufficient Funds !");
	}
	
	public InsufficientFunds(String message) {
		super(message);
	}
}