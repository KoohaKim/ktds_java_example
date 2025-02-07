package inheritance;

public class Apu extends Cpu{

	public Apu(String manufactor, String seriesNum) {
		super(manufactor, seriesNum);
	}

	@Override
	public void calculate() {
		super.calculate();
		System.out.println("");
		super.calculate();
	}
	
}
