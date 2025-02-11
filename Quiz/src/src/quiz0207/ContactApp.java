package quiz0207;

import quiz0207.exceptions.ContactMaxCountException;
import quiz0207.exceptions.ContactNotFoundException;
import quiz0207.exceptions.ContactOutOfBoundException;
import quiz0207.exceptions.NullContactException;

public class ContactApp implements ContactManager {
	private int size; // contacts배열 에 들어간 연락처의 개수
	private Contact[] contacts;

	public ContactApp(int contactMaxCount) {
		// contactCount :최대 연락처 개수
		validContactMaxCount(contactMaxCount);

		this.contacts = new Contact[contactMaxCount];
	}

	private void validContactMaxCount(int contactMaxCount) {
		if (contactMaxCount < 0) {
			throw new ContactMaxCountException("연락처 개수는 음수 일 수 없습니다.");
		}
	}

	@Override
	public void addNewContact(Contact contact) {
		if (this.size >= this.contacts.length) {
			throw new ContactOutOfBoundException("연락처 저장 공간이 없습니다.");
		} else if (contact == null) {
			throw new NullContactException("연락처가 Null입니다.");
		}
		this.contacts[size++] = contact;
	}

	@Override
	public Contact getContactAt(int contactIndex) {
		if (contactIndex < 0 || contactIndex >= this.size || this.contacts.length < contactIndex) {
			throw new ContactNotFoundException("유효하지 않은 인덱스 입니다.");
		}
		return this.contacts[contactIndex];

	}

	@Override
	public void sort() {
		Contact temp;
		for (int i = 0; i < this.size - 1; i++) {
			for (int j = i + 1; j < this.size; j++) {
				if (this.contacts[i].getId() > this.contacts[j].getId()) {
					temp = this.contacts[i];
					this.contacts[i] = this.contacts[j];
					this.contacts[j] = temp;
				}
			}
		}
	}

	@Override
	public void removeContact(int contactIndex) {
		if (contactIndex < 0 || contactIndex >= this.size || this.contacts.length <= contactIndex) {
			throw new ContactNotFoundException("유효하지 않은 인덱스 입니다.");
		}
		this.contacts[contactIndex] = null;
	}

	public void printAllContact() {
		for (int i = 0; i < this.size; i++) {
			if(this.contacts[i] == null) {
				throw new NullContactException("배열 내에 Null객체 있음");
			}
			System.out.println(this.contacts[i]);
		}
	}
}
