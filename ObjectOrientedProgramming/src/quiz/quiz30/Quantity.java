package quiz.quiz30;

public class Quantity {
    private int quantity;

    public Quantity(int quantity) {
        this.quantity = validQuantity(quantity);
    }

    public int getQuantity() {
        return quantity;
    }

    private int validQuantity(int quantity){
        if (quantity < 0) {
            return 1;
        }
        return quantity;
    }

}
