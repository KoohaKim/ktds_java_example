package homework.homework0121;

public class MethodQuizStar {
	private static final String STAR = "*";

	private final int numberOfLine;
	
	public MethodQuizStar(int numberOfLine) {
		this.numberOfLine = numberOfLine;
	}

	
	public  void createStar() {
		final int startLine = 0;
		
		for (int i = startLine; i < numberOfLine; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print(STAR);
			}
			System.out.println();
		}
	}
	
	
	public static void main(String[] args) {
		new MethodQuizStar(10).createStar();
	}
}
