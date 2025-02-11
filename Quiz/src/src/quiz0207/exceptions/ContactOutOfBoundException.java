package quiz0207.exceptions;

//contactIndex가 this.contacts.length 보다 크거나 같을 때 던지기
public class ContactOutOfBoundException extends RuntimeException{

	public ContactOutOfBoundException(String message) {
		super(message);
	}

	
}
