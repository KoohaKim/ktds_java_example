package abstractclass;

public class RealWorld {

	public static void behavior(Animal animal) {
		animal.movement();
		animal.breath();
		animal.eat();
		System.out.println();
	}
	
	
	public static void main(String[] args) {
		Animal dogAnimal = new Dog("두치","집");
		behavior(dogAnimal);
		
		Animal humAnimal = new Human("집", "구하", "27");
		behavior(humAnimal);
		
		Animal snakeAnimal = new Snake("야산");
		behavior(snakeAnimal);
	}
}
