package com.ktdsuniversity.edu.fruitseller;

public class Mart {
	public static void main(String[] args) {
		FruitSeller coupang = new FruitSeller(100, 1000);
		
		coupang.sell(10);
		coupang.sell(5);
		coupang.sell(7);
		coupang.sell(20);
		
		System.out.println(coupang.getMoney());
		System.out.println(coupang.getFruitStock());
	}
}
