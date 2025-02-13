package quiz0213.장민창;

public class Contact {

	private int number;
	private String name;
	private String phoneNumber;
	private String profile;
	
	public Contact(int number, String name, String phoneNumber, String profile) {
		this.number = number;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.profile = profile;
	}
	
	public int getNumber() {
		return this.number;
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("No. " + this.number + "\n");
		sb.append("Name. " + this.name + "\n");
		sb.append("PhoneNumber. " + this.phoneNumber + "\n");
		sb.append("Profile. " + this.profile + "\n");
		return sb.toString();
	}
	
}
