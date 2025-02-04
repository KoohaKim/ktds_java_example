package com.ktdsuniversity.edu.fruitseller;

public class FruitSeller {
	private final int FRUIT_PRICE = 500;
	private int money;
	private int fruitStock;
	
	public FruitSeller(int money, int fruitStock) {
		this.money = money;
		this.fruitStock = fruitStock;
	}
	
	public void sell(int quantity) {
		if (this.fruitStock >= quantity) {
			this.fruitStock -= quantity;
			this.money += FRUIT_PRICE*quantity;
		}
	}
	
	public int getMoney() {
		return this.money;
	}

	public int getFruitStock() {
		return this.fruitStock;
	}

	
}
