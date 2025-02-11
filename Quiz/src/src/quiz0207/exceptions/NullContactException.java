package quiz0207.exceptions;

//contactIndex가 this.size 보다 작지만 contactIndex에 저장된 값이 null일 때 던지기
public class NullContactException extends RuntimeException{

	public NullContactException(String message) {
		super(message);
	}

	
}
