package banque.domain.exception;

public class CompteNotFound extends RuntimeException {
	
	public CompteNotFound() {
		super("Account Not Found !");
	}
	
	public CompteNotFound(String message) {
		super(message);
	}
}