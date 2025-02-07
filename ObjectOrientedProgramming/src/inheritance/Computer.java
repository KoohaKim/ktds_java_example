package inheritance;

public class Computer {
	public static void main(String[] args) {
		new Cpu("intel", "i8").calculate();
		
		System.out.println();
		
		Cpu amdChipCpu = new Apu("AMD", "Rizen7");
		amdChipCpu.calculate();	
		

	}
}
