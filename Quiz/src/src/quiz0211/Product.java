package quiz0211;

import java.util.Objects;

import quiz0211.exception.InvalidIndexException;

public class Product {
	private int id;
	private String name;
	private int price;
	private int quantity;
	private int expirationDate;
	
	public Product(int id, String name, int price, int quantity, int expirationDate) {
		validParam(id, price, quantity);
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.expirationDate = expirationDate;
	}
	
	private void validParam(int ... param) {
		for(int value: param) {
			if(value < 0) {
				throw new InvalidIndexException(value + "는 음수일 수 없습니다.");
			}
		}
	}

	@Override
	public String toString() {
		return "\n id: " + this.id + 
				", 품명:" + this.name + 
				", 가격:" + this.price + 
				", 수량:" + this.quantity
				+ ", 소비기한:" + this.expirationDate + "days" + "\n";
	}

	
	public int getId() {
		return this.id;
	}


	public String getName() {
		return this.name;
	}

	public int getPrice() {
		return this.price;
	}

	

	public int getQuantity() {
		return this.quantity;
	}
	
	public void addQuantity() {
		this.quantity += 1;
	}
	public void decreaseQuantity() {
		this.quantity -= 1;
	}
	

	public int getExpirationDate() {
		return this.expirationDate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(expirationDate, id, name, price, quantity);
	}

	@Override
	public boolean equals(Object obj) {
	    if (this == obj) return true;
	    if (obj == null || getClass() != obj.getClass()) return false;
	    Product other = (Product) obj;
	    return id == other.id && Objects.equals(name, other.name);
	}


	
	
	
	
	
	
	
}
