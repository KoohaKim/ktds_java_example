package quiz0207;

public class AdditionalContact extends Contact{
	private String dateOfBirth;
	private String companyName;
	private String position;
	private String address;
	
	public AdditionalContact(long id, String name,String phone,String photoUrl,
							 String dateOfBirth, String companyName, String position, String address) {
        super(id, name, phone, photoUrl);
        this.dateOfBirth = dateOfBirth;
		this.companyName = companyName;
		this.position = position;
		this.address = address;
	}

	@Override
	public String toString() {
		return 	super.toString() +
				", dateOfBirth='" + dateOfBirth + '\'' +
				", companyName='" + companyName + '\'' +
				", position='" + position + '\'' +
				", address='" + address;
	}

}
