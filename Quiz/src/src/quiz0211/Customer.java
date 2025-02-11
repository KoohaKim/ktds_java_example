package quiz0211;

import java.util.Arrays;

import quiz0211.exception.InvalidIndexException;
import quiz0211.exception.InvalidMoneyException;
import quiz0211.exception.NullProductException;

public class Customer {
	private int wallet;
	private Product[] purchaseProducts;
	private int idx;

	public Customer(int wallet, int numberOfProducts) {
		this.wallet = wallet;
		this.purchaseProducts = new Product[numberOfProducts];
	}

	public void pay(int price) {
		ParamUtils.checkValidMoney(price);

		if (this.wallet < price) {
	        throw new InvalidMoneyException("잔액이 부족합니다.");

		}

		this.wallet -= price;
	}

	public void receiveProduct(Product product) {
		checkIdxAndNullProduct(product);

		for (Product pd : this.purchaseProducts) {
			if (pd != null && pd.equals(product)) {
				pd.addQuantity();
				return;
			}
		}

		this.purchaseProducts[idx++] = new Product(product.getId(), product.getName(), product.getPrice(), 1,
				product.getExpirationDate());
	}

	private void checkIdxAndNullProduct(Product product) {
		if (product == null) {
			throw new NullProductException("상품을 찾을 수 없습니다.");
		}
		if (this.idx >= this.purchaseProducts.length) {
			throw new InvalidIndexException("유효하지 않은 인덱스 입니다.");
		}
	}

	public void receiveMoney(int money) {
		ParamUtils.checkValidMoney(money);
		this.wallet += money;
	}

	public void printCustomerStatus() {
		System.out.println("지갑 남은 금액: " + this.wallet + ", 구매한 상품: " + Arrays.toString(this.purchaseProducts));
	}

	public int getWallet() {
		return this.wallet;
	}

	public void refundToWallet(int money) {
		this.wallet += money;
	}

	public Product[] getPurchaseProducts() {
		return purchaseProducts;
	}

}
