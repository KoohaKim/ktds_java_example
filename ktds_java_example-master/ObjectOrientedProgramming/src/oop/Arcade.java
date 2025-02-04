package oop;

public class Arcade {

	
	public static void main(String[] args) {
		CraneGameMachine craneGameMachine = new CraneGameMachine();
		
		craneGameMachine.dolls = 1;
		
		
		craneGameMachine.insertCoin();	
		craneGameMachine.doGame();
		
		System.out.println("남은 인형: " + craneGameMachine.dolls);		
			
		
	}
}
