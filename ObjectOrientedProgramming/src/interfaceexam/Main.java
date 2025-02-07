package interfaceexam;

public class Main {
	public static void main(String[] args) {
		LgRemoteControll lgRemote = new LgRemoteControll();
		RemoteControl godRemoteControl = new StandartTvRemoteControl();
		DanawaRemoteControl danawaRemoteControl = new DanawaRemoteControl();	
		
		SamsungTv samsungTv = new SamsungTv();
//		samsungTv.welcome(lgRemote);
//		samsungTv.goodBye(danawaRemoteControl);
		
		LgTv lgTv = new LgTv();
		lgTv.on(lgRemote);
		System.out.println();
		lgTv.off(danawaRemoteControl);
	}
}
