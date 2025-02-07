package interfaceexam;

public class LgRemoteControll implements RemoteControl {

	@Override
	public void powerOn() {
		System.out.println("tv on");
		
	}

	@Override
	public void powerOff() {
		System.out.println("tv off");
	}
	 
}
