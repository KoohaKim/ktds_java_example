package quiz0207;

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
			System.out.println("입력값이 null 또는 비어있습니다.");
		}
	}

	@Override
	public String toString() {
		return super.toString() + ", dateOfBirth='" + dateOfBirth + '\'' + ", companyName='" + companyName + '\''
				+ ", position='" + position + '\'' + ", address='" + address;
	}

}
