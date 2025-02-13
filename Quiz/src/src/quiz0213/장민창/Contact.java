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

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getProfile() {
        return profile;
    }

    @Override
    public String toString() {
        return "%d / %s / %s / %s"
                .formatted(
						this.number,
						this.name,
						this.phoneNumber,
						this.profile
				);

    }

}
