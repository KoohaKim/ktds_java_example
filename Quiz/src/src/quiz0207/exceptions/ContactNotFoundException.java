package quiz0207.exceptions;
 
//contactIndex가 this.contacts.length 보다 작지만 this.size보다 크거나 같을 때 던지기
public class ContactNotFoundException extends RuntimeException{

	public ContactNotFoundException(String message) {
		super(message);
	}

	
}
