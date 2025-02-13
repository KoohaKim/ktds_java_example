package quiz0213.장민창;

import java.util.ArrayList;
import java.util.List;

import 과제.hw0207.장민창.exceptions.ContactNotFoundException;

public class OtherContactApp implements ContactAppInterface {

	private List<Contact> contacts;

	public OtherContactApp(String fileDirectoryPath, String filename) {
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
		// Bubble Sort
		for (int i = 0; i < this.contacts.size(); i++) {
			for (int j = 0; j < this.contacts.size() - 1 - i; j++) {
				if (this.contacts.get(j-1).getNumber() < this.contacts.get(j).getNumber()) {
					Contact temp = this.contacts.get(j);
					this.contacts.set(j, this.contacts.get(j+1));
					this.contacts.set(j+1, temp);
				}
			}
		}
	}
}