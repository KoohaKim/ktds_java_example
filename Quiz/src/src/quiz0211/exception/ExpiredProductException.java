package quiz0211.exception;

public class ExpiredProductException extends RuntimeException{

	public ExpiredProductException(String message) {
		super(message);
	}
}
