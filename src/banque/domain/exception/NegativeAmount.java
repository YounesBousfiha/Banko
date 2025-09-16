package banque.domain.exception;

public class NegativeAmount extends RuntimeException {
	
	public NegativeAmount() {
		super("Negative Amount !");
	}
	
	public NegativeAmount(String message) {
		super(message);
	}
}