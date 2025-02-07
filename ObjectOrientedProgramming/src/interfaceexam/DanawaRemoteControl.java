package interfaceexam;

public class DanawaRemoteControl implements DanawaTvSignal {

	@Override
	public void powerOn() {
		System.out.println("켜져라");

	}

	@Override
	public void powerOff() {
		System.out.println("꺼져라");

	}
	
	public void openDanawaPage() {
		System.out.println("브라우저 실행 다나와 접속");
	}

}
