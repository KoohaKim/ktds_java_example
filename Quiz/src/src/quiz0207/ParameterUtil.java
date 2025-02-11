package quiz0207;

public class ParameterUtil {

	public static boolean isEmpty(String ... param) {
		for(String value : param) {
			return value == null || value.isBlank();
		}
		return false;
	}
	
	
}
