package inheritance;

import java.util.Objects;

public 	class Contact {
	private String name;
	private String phone;
	
	public Contact(String name, String phone) {
		this.name = name;
		this.phone = phone;
	}
	
	public void printContact() {
		System.out.println("name: " + this.name + ", phone: " + this.phone	);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, phone);
	}

	@Override
	public boolean equals(Object obj) {	
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contact other = (Contact) obj;
		return Objects.equals(name, other.name) && Objects.equals(phone, other.phone);
	}

	@Override
	public String toString() {
		return "name: " + this.name + ", phone: " + this.phone;

	}

	public String getName() {
		return name;
	}

	public String getPhone() {
		return phone;
	}

}
