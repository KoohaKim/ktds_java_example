package com.ktdsuniversity.edu.comicbookcafe;

public class ComicBookCafe {
	public static final int RENTAL_FEE;

	static {
		RENTAL_FEE = 100;
	}
	
	
	private int account;
	private ComicBook comicBook1;
	private ComicBook comicBook2;
	private ComicBook comicBook3;

	public ComicBookCafe(int account, ComicBook comicBook1, ComicBook comicBook2, ComicBook comicBook3) {
		this.account = account;
		this.comicBook1 = comicBook1;
		this.comicBook2 = comicBook2;
		this.comicBook3 = comicBook3;
	}

	public void rentalBook(ComicBook book) {
		if (book.getRentalStatus()) {
			System.out.println("이미 대여중인 만화책 입니다.");
		} else if (!book.getRentalStatus()) {
			account += RENTAL_FEE;
			book.changeRentalStatus();
		}
	}

	public ComicBook returnBook(ComicBook book) {
		if (book.getRentalStatus()) {
			book.changeRentalStatus();
			System.out.println(book.getTitle() + " 반납 완료");
			return book;
		} else if (!book.getRentalStatus()) {
			System.out.println("대여된 책이 아닙니다.");
		}
		return book;
	}

	public void printCurrentAccount() {
		System.out.println("잔액: " + account);
	}

	public void printAllComicBook() {
		System.out.println("제목: " + comicBook1.getTitle() + ", 대여상태: " + comicBook1.getRentalStatus());
		System.out.println("제목: " + comicBook2.getTitle() + ", 대여상태: " + comicBook2.getRentalStatus());
		System.out.println("제목: " + comicBook3.getTitle() + ", 대여상태: " + comicBook3.getRentalStatus());
	}

}
