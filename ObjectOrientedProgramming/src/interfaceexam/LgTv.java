package interfaceexam;

public class LgTv {
	public void on(RemoteControl signal) {
		signal.powerOn();
		System.out.println("Life is Good");
	}
	
	public void off(RemoteControl signal) {
		signal.powerOff();
	}
}
