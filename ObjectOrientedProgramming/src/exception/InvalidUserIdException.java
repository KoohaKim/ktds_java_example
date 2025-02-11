package exception;

public class InvalidUserIdException extends RuntimeException{
	private String message;
	
	
	
	public InvalidUserIdException(String message) {
		this.message = message;
	}



	public String getMessage() {
		return this.message;
	}
	
	
	
}
