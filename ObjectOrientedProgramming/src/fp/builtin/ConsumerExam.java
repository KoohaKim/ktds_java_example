package fp.builtin;

import java.util.function.Consumer;

public class ConsumerExam {
	public static void main(String[] args) {
		//반환이 없다
		Consumer<String> printFnConsumer = (input) -> System.out.print(input);
		printFnConsumer.accept("반갑습니다.");
		
		
	}
	
}
