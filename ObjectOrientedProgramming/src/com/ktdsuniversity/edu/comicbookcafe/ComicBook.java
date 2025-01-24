package com.ktdsuniversity.edu.comicbookcafe;

public class ComicBook {
	private String title;
	private boolean rentalStatus;

	public ComicBook(String title) {
		this.title = title;
		this.rentalStatus = false;
	}

	public String getTitle() {
		return this.title;
	}

	public boolean getRentalStatus() {
		return this.rentalStatus;
	}

	public boolean changeRentalStatus() {
		System.out.println("제목: " + this.title + " -> " + changeRentalStatusToString(!this.rentalStatus) + " 으로 변환");
		return this.rentalStatus = !rentalStatus;
	}

	private String changeRentalStatusToString(boolean rentalStatus) {
		if (rentalStatus) {
			return "대여중";
		} else if (!rentalStatus) {
			return "대여 가능";
		}
		return null;
	}

}
