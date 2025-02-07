
public class Contact {
	private int number;
	private String name;
	private int phone;
	private String photo;
	
	public Contact(int number, String name, int phone, String photo) {
		this.number = number;
		this.name = name;
		this.phone = phone;
		this.photo = photo;
	}

	@Override
	public String toString() {
		return "number=" + number + ", name=" + name + 
				", phone=" + phone + ", photo=" + photo;
	}
	
	
	
}
