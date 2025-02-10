package quiz0207;

public class Contact {
	private long id;
	private String name;
	private String phone;
	private String photoUrl;

	public Contact(long id, String name, String phone, String photoUrl) {
		validContact(id, name, phone, photoUrl);
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.photoUrl = photoUrl;
	}

	private void validContact(long id, String name, String phone, String photoUrl) {
		if (id < 0) {
			System.out.println("id는 음수일 수 없습니다.");
		} else if (name == null || phone == null || photoUrl == null || name.isBlank() || phone.isBlank() || photoUrl.isBlank()) {
			System.out.println("입력값이 null 또는 비어있습니다.");
		}
	}

	@Override
	public String toString() {
		return "id=" + id + ", name=" + name + ", phone=" + phone + ", photo=" + photoUrl;
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
