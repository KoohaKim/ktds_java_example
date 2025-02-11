package quiz0207;

import quiz0207.exceptions.NullContactException;

public class AdditionalContact extends Contact {
	private String dateOfBirth;
	private String companyName;
	private String position;
	private String address;

	public AdditionalContact(long id, String name, String phone, String photoUrl, String dateOfBirth,
			String companyName, String position, String address) {
		super(id, name, phone, photoUrl);
		validAdditionalContact(dateOfBirth, companyName, position, address);
		this.dateOfBirth = dateOfBirth;
		this.companyName = companyName;
		this.position = position;
		this.address = address;
	}

	private void validAdditionalContact(String dateOfBirth, String companyName, String position, String address) {
		if (ParameterUtil.isEmpty(dateOfBirth, companyName, position, address)) {
			throw new NullContactException("입력 값이 비어있습니다.");
		}
	}

	@Override
	public String toString() {
		return super.toString() + ", dateOfBirth='" + this.dateOfBirth + '\'' + ", companyName='" + this.companyName + '\''
				+ ", position='" + this.position + '\'' + ", address='" + this.address;
	}

}
