package quiz.quiz30;

public class Seller {
	private int account;

	public Seller(int account) {
		this.account = account;
	}

	public void sellProduct(Customer customer, Product product, Quantity orderQuantity) {
		int totalPrice = orderQuantity.getQuantity() * product.getPrice();

		// 잔액이 부족할 경우
		if (customer.getAccount() < totalPrice){
			System.out.println("잔액 부족... 보유 잔액: " + customer.getAccount() + "원, 주문 금액: " + totalPrice + "원 \n");
			return;
		}

		// 주문 수량이 많을 경우
		if (product.getQuantityInt() == 0) {
			System.out.println("상품 매진 입니다 ㅜㅜ");
			return;
		}else if(orderQuantity.getQuantity() > product.getQuantityInt()){
			System.out.println("주문 ....! \n 주문 수량: " + orderQuantity.getQuantity() + "개, 상품 보유 수량: " + product.getQuantityInt() + "개 \n" + "판매 완료^.^");
			this.account += product.getPrice() * product.getQuantityInt();
			System.out.println("판매자의 금고: " + account + "원, 판매한 상품: " + product.getName() + ", 상품의 개수: " + product.getQuantityInt() + ", 상품 가격: " + product.getPrice() + "원");
			System.out.println("구매자의 금고: " + customer.getAccount() + "원, 구매한 상품의 개수: " + orderQuantity.getQuantity() +"\n");

			product.setQuantity(new Quantity(0));

			return;
		}

		// normal case
		product.setQuantity(new Quantity(product.getQuantityInt() - orderQuantity.getQuantity()));
		this.account += totalPrice;
		customer.setAccount(customer.getAccount() - totalPrice);
		System.out.println("주문 완료!...  \n판매자의 금고: " + account + "원, 판매한 상품: " + product.getName() + ", 상품의 개수: " + product.getQuantityInt() + ", 상품 가격: " + product.getPrice() + "원");
		System.out.println("구매자의 금고: " + customer.getAccount() + "원, 구매한 상품의 개수: " + orderQuantity.getQuantity() +"\n");
	}
}
