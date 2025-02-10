package quiz0207;

public class Main {
	public static void main(String[] args) {
		ContactApp contactApp = new ContactApp(5);

		Contact contact1 = new Contact(1, "구하", "010-7221-2038", "PHOTO.jpg");
		Contact contact2 = new AdditionalContact(2, "구순", "010-1234-1234", "PHOTO.png", "1998-01-01", "KT_DS", "사원",
				"서울특별시 관악구 신림로 ");
		Contact contact3 = new Contact(3, "구돌", "010-5678-5678", "PHOTO.jpg");
		Contact contact4 = new Contact(4, "구밥", "010-7777-7777", "PHOTO.jpg");
		Contact contact5 = new Contact(5, "구혁", "010-1212-1212", "PHOTO.jpg");

		contactApp.addNewContact(contact2);
		contactApp.addNewContact(contact3);
		contactApp.addNewContact(contact4);
		contactApp.addNewContact(contact1);
		contactApp.addNewContact(contact5);

		System.out.println("정렬 전 연락처: ");
		contactApp.printAllContact();

		contactApp.sort();
		System.out.println();

		System.out.println("정렬 후 연락처:");
		contactApp.printAllContact();

		System.out.println("getContactAt 인덱스 조회: " + contactApp.getContactAt(1));

	}
}
