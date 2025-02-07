package interfaceexam;

public class StandartTvRemoteControl implements RemoteControl {

	@Override
	public void powerOn() {
		System.out.println("standard on");

	}

	@Override
	public void powerOff() {
		System.out.println("standard off");

	}

}
