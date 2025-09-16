package banque.domain.exception;

public class DecouvertLimitExceeded extends RuntimeException {
	
	public DecouvertLimitExceeded() {
		super("Credit Limit Surpass !");
	}
	
	public DecouvertLimitExceeded(String message) {
		super(message);
	}
}