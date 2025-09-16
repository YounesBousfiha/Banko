package banque.domain.util;

public class ValidationUtils {
	
	
	public static boolean CheckValidCode(String code) {
		return code.matches("CPT-\\d{3}");
	}
}