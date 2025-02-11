package exception;

public class HandleExceptionType {

	public static void loadClass(String classPath) {
		try {
			Class classes = Class.forName(classPath);
		} catch (ClassNotFoundException e) {
			//클래스패스가 존재하지 않는 크래스일 때 던져진 예외
			throw new IllegalArgumentException("존재 하지 않는 클래스 입니다.: " + e.getMessage());
		}

	}
	
	public static void main(String[] args) {
		loadClass("com.ktdsuniversity.edu.fruitseller.FruitSeller");//o
//		loadClass("com.ktdsuniversity.edu.fruitseller");//x
	}
}
