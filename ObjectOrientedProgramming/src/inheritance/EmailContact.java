package inheritance;

public class EmailContact extends Contact{
	private String email;
	
	public EmailContact(String name, String phone, String email) {
		super(name, phone);
		this.email = email;
	}
	
	@Override
	public void printContact() {
		super.printContact();
		System.out.println("email: " + this.email);
	}

	
	
	@Override
	public String toString() {
		return "이름: " + super.getName() + ", 전화: " + super.getName() + ", email: " + this.email;
	}

	public static void main(String[] args) {
		Contact contact = new Contact("guha", "1234565");
		Contact otherContact = new Contact("guha", "1234565");

		Contact eContact = new EmailContact("conE", "010-4555-4555", "naver");

		EmailContact emailContact = new EmailContact("Econ", "010-5151-5151", "daum");
		
		
		System.out.println(contact.equals(otherContact));
		System.out.println(contact);
		System.out.println(eContact);
		System.out.println(emailContact);
	}
}
