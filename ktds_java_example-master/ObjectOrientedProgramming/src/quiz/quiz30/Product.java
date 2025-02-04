package quiz.quiz30;

public class Product {
    private String name;
    private Quantity quantity;
    private int price;

    public Product(String name, Quantity quantity, int price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantityInt() {
        return quantity.getQuantity();
    }

    public void setQuantity(Quantity quantity) {
        this.quantity = quantity;
    }
}
