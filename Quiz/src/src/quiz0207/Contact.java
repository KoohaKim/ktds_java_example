package quiz0207;

import quiz0207.exceptions.NullContactException;

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
		if (id <= 0) {
			System.out.println("id는 0 이하일 수 없습니다.");
		} else if (ParameterUtil.isEmpty(name, phone, photoUrl)) {
			throw new NullContactException("입력 값이 비어있습니다.");
		}
	}

	@Override
	public String toString() {
		return "id=" + this.id + ", name=" + this.name + ", phone=" + this.phone + ", photo=" + this.photoUrl;
	}

	public long getId() {
		return this.id;
	}

}
