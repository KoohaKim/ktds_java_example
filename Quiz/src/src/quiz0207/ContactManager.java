package quiz0207;

public interface ContactManager {
    void addNewContact(Contact contact);

    Contact getContactAt(int contactIndex);

    void sort();
    
    void removeContact(int contactIndex);
    
}
