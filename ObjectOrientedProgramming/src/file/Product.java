package src.file;

public class Product {
	private String name;
	private int price;
	private int stock;

	public Product(String[] itemArray) {
		this.name = itemArray[0];
		this.price = Integer.parseInt(itemArray[1]);
		this.stock = Integer.parseInt(itemArray[2]);
	}

	public Product(String name, int price, int stock) {
		this.name = name;
		this.price = price;
		this.stock = stock;
	}

	public String toFileFormat() {
		return "%s,%d,%d".formatted(this.name, this.price, this.stock);
	}

	@Override
	public String toString() {
		return "%s / %d / %d".formatted(this.name, this.price, this.stock);
	}

}
