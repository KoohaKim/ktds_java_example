package com.ktdsuniversity.edu.comicbookcafe;

public class Main {
	public static void main(String[] args) {
		ComicBook 마법천자문 = new ComicBook("마법천자문");
		ComicBook 메이플스토리 = new ComicBook("메이플스토리");
		ComicBook 무인도에서살아남기 = new ComicBook("무인도에서 살아남기");
		int account = 100_000;

		ComicBookCafe cafe = new ComicBookCafe(account, 마법천자문, 메이플스토리, 무인도에서살아남기);
		cafe.printCurrentAccount();
		cafe.rentalBook(무인도에서살아남기);

		cafe.printCurrentAccount(); // 10,000 증가

		cafe.printAllComicBook();
//		cafe.returnBook(무인도에서살아남기);
//		cafe.printAllComicBook();
//		cafe.rentalBook(무인도에서살아남기); //대여중인 책 대여되는지 검증

	}
}
