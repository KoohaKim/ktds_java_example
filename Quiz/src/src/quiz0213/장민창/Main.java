package quiz0213.장민창;

public class Main {

	public static void run() {
//		ContactAppInterface app1 = new OtherContactApp();
		ContactAppInterface app2 = new ContactApp("C:\\Users\\Guha\\Desktop\\example", "example.txt");
	}

	public static void main(String[] args) {
//		run();
		new ContactApp("C:\\Users\\Guha\\Desktop\\example", "example.txt").writeData("C:\\Users\\Guha\\Desktop\\example", "example.txt");
	}


}
