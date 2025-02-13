package quiz0213.장민창;

import java.util.ArrayList;
import java.util.List;

import 과제.hw0207.장민창.exceptions.ContactNotFoundException;

public class ContactApp implements ContactAppInterface {

	private List<Contact> contacts;

	public ContactApp(String fileDirectoryPath, String filename) {
		this.contacts = new ArrayList<>();
		this.loadData(fileDirectoryPath, filename);
	}

	@Override
	public void loadData(String fileDirectoryPath, String filename) {
		// 파일을 읽어서 this.contacts 에 연락처 목록을 할당한다.
	}

	@Override
	public void writeData(String fileDirectoryPath, String filename) {
		// this.contact에 있는 연락처 정보를 파일에 쓴다.
	}
	
	@Override
	public void clean() {
		this.contacts.clear();
	}

	@Override
	public void addNewContact(Contact newContact) {
		this.contacts.add(newContact);
	}

	@Override
	public void remove(int contactIndex) {
		if (contactIndex >= 0 && contactIndex < this.contacts.size()) {
			this.contacts.remove(contactIndex);
		}
	}

	@Override
	public Contact getContactAt(int contactIndex) {
		if (contactIndex < this.contacts.size() && contactIndex >= this.contacts.size()) {
			throw new ContactNotFoundException(contactIndex + " 연락처가 아직 채워지지 않은 인덱스입니다.");
		}
		return this.contacts.get(contactIndex);
	}
	
	@Override
	public void sort() {
		// Selection Sort
		int minIdx = 0;
		for (int i = 0; i < this.contacts.size(); i++) {
			minIdx = i;
			for (int j = i + 1; j < this.contacts.size(); j++) {
				if (this.contacts.get(minIdx) != null && this.contacts.get(j) != null) {
					if ( this.contacts.get(minIdx).getNumber() > this.contacts.get(j).getNumber() ) {
						minIdx = j;
					}
				}
			}
			
			if (minIdx != i) {
				Contact temp = this.contacts.get(minIdx);
				if (temp != null && this.contacts.get(i) != null) {
					this.contacts.set(minIdx, this.contacts.get(i));
					this.contacts.set(i, temp);
				}
			}
		}
	}


}
