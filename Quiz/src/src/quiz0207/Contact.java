package quiz0207;

public class Contact {
	private long id;
	private String name;
	private String phone;
	private String photoUrl;
	
	public Contact(long id, String name, String phone, String photoUrl) {
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.photoUrl = photoUrl;
	}

	@Override
	public String toString() {
		return "id=" + id + ", name=" + name +
				", phone=" + phone + ", photo=" + photoUrl;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getPhone() {
		return phone;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}
}
