package banque.domain.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ValidationUtils {
	
	private static final Set<String> VALID_TYPES = new HashSet<>(Arrays.asList("courant", "epargne"));
	
	public static boolean CheckValidCode(String code) {
		if(code == null || code.isEmpty()) {
			return false;
		}
		return code.matches("CPT-\\d{3}");
	}
	
	public static boolean isDouble(String value) {
		if(value == null || value.isEmpty()) return false;
		try {
			Double.parseDouble(value);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	
	public static boolean isValidAccountType(String type) {
	    if (type == null || type.isEmpty()) return false;
	    return type != null && VALID_TYPES.contains(type.toLowerCase());
	}
	
	public static boolean isNegative(Double value) {
		if(value < 0) {
			return true;
		}
		return false;
	}
}