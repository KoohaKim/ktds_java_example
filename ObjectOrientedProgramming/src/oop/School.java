package oop;

public class School {

	public static void main(String[] args) {
		Student student = new Student();
		student.java = 100;
		student.python = 97;
		student.cpp = 81;
		student.csharp = 99;
		
		System.out.println(student.getSumAll());
		System.out.println("평균: " + student.getAverage());
		System.out.println(student.getCourseCredit());
		System.out.println("학점: "+student.getABCDE());
	
	}
	
}
