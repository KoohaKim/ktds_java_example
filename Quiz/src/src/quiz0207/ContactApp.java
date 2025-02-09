package quiz0207;

public class ContactApp implements ContactManager{
    private int size; // contacts배열 에 들어간 연락처의 개수
    private Contact[] contacts;


    public ContactApp(int contactMaxCount) {
        // contactCount : contacts 배열에 들어갈 수 있는 최대 연락처 개수
        this.contacts = new Contact[contactMaxCount];
        this.size = 0;
    }

    @Override
    public void addNewContact(Contact contact) {
        if (size >= contacts.length) {
            System.out.println("연락처 저장 공간이 없습니다.");
            return;
        }
        this.contacts[size++] = contact;
    }

    @Override
    public Contact getContactAt(int contactIndex) {
        if (contactIndex < 0 || contactIndex >= size) {
            System.out.println("유효하지 않은 인덱스 입니다.");
            return null;
        }
        return this.contacts[contactIndex];
    }


    @Override
    public void sort() {
        Contact temp;
        for (int i = 0; i < size - 1; i++) {
            for (int j = i+1; j < size; j++) {
                if (contacts[i].getId() > contacts[j].getId()) {
                    temp = contacts[i];
                    contacts[i] = contacts[j];
                    contacts[j] = temp;
                }
            }
        }
    }


    public void printAllContact(){
        for (int i = 0; i < size; i++) {
            System.out.println(contacts[i]);
        }
    }
}
