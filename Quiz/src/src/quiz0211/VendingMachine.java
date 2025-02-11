package quiz0211;

import quiz0211.exception.ExpiredProductException;
import quiz0211.exception.InvalidIdException;
import quiz0211.exception.InvalidMoneyException;
import quiz0211.exception.NeedMoreMoneyException;
import quiz0211.exception.SoldOutException;

public class VendingMachine {
	private Product[] products;
	private int account;
	private int inputMoney;

	public VendingMachine(Product[] products) {
		this.products = products;
	}

	// inputMoney는 사용자가 자판기에 투입한 금액이라고 가정
	public void sellProduct(int id, int inputMoney, Customer customer) {
		Product product = checkValidParams(id, inputMoney);
		int productPrice = product.getPrice();

		if (inputMoney > customer.getWallet()) {
			throw new InvalidMoneyException("당신에게 그런 돈은 없을 텐데");
		}

		customer.pay(inputMoney);

		int refund = inputMoney - productPrice;

		if (refund > 0) {
			customer.receiveMoney(refund);
		}

		customer.receiveProduct(product);
		product.decreaseQuantity();
		this.account += productPrice;
		this.inputMoney = 0;
	}

	private Product checkValidParams(int id, int inputMoney) {
		ParamUtils.checkValidMoney(inputMoney);

		if (id < 0 || id > this.products.length) {
			throw new InvalidIdException("유효한 Id 값이 아닙니다.");
		}

		for (Product pd : this.products) {
			if (pd.getId() == id) {
				checkValidProduct(inputMoney, pd);
				return pd;
			}
		}
		throw new InvalidIdException("상품을 찾을 수 없음");
	}

	private void checkValidProduct(int inputMoney, Product product) {
		if (product.getExpirationDate() < 0) {
			throw new ExpiredProductException(product.getName() + " 상품의 소비기한이 0 미만입니다.");
		} else if (product.getQuantity() <= 0) {
			throw new SoldOutException(product.getName() + "상품의 재고가 0 이하 입니다.");
		} else if (product.getPrice() > inputMoney) {
			throw new NeedMoreMoneyException("잔액이 부족합니다. 상품 가격보다 높은 금액을 지불하세요");
		}
	}

	public void refundMoney(Customer customer) {
		customer.refundToWallet(this.inputMoney);
		this.inputMoney = 0;
	}

	public void printVendingMachineStatus() {
		System.out.println("자판기: InputMoney: " + this.inputMoney + "\n" + "Account: " + this.account);
	}

}
