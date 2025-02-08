package quiz0207;

public class ContactApp {
	private int size; // contacts배열 에 들어간 연락처의 개수
	private Contact[] contacts;
	
	
	public ContactApp(int contactMaxCount) {
	    // contactCount : contacts 배열에 들어갈 수 있는 최대 연락처 개수
	    this.contacts = new Contact[contactMaxCount];
	}

	
	public void addNewContact(Contact contact) { 
		
	}
	
	public Contact getContactAt(int contactIndex) { 
		
		return contacts[contactIndex];
	}
	
}
