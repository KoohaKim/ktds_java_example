package quiz;
/*
 * Animal 클래스로 여러가지 인스턴스를 만들어보세요.
- 강아지 인스턴스 여러개
- 고양이 인스턴스 여러개 등등
 */
public class Quiz27 {
	public static void main(String[] args) {
		Animal dog = new Animal("마루", "개", "멍 멍");
		Animal cat = new Animal("뚱냥", "고양이", "먀옹");
		Animal parrot = new Animal("삐약이", "새", "안녕하세요? 전 삐약이에요");
		
		dog.bark();
		cat.bark();
		parrot.bark();
		System.out.println();
		dog.introduce();
		cat.introduce();
		parrot.introduce();
	}
}
