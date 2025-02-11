package quiz0207;

public class ContactApp implements ContactManager{
    private int size; // contacts배열 에 들어간 연락처의 개수
    private Contact[] contacts;


    public ContactApp(int contactMaxCount) {
        // contactCount :최대 연락처 개수
    	validContactMaxCount(contactMaxCount);
    	
        this.contacts = new Contact[contactMaxCount];
        this.size = 0;
    }

    private void validContactMaxCount(int contactMaxCount) {
    	if(contactMaxCount < 0) {
    		System.out.println("연락처의 개수는 음수일 수 없습니다.");
    	} 
	}
    
    @Override
    public void addNewContact(Contact contact) {
        if (size >= this.contacts.length) {
            System.out.println("연락처 저장 공간이 없습니다.");
            return;
        }else if(contact == null) {
        	System.out.println("연락처가 Null입니다.");
        	return;
        }else if(contact != null){
        	this.contacts[size++] = contact;
        }
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
                if (this.contacts[i].getId() > this.contacts[j].getId()) {
                    temp = contacts[i];
                    this.contacts[i] = this.contacts[j];
                    this.contacts[j] = temp;
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
