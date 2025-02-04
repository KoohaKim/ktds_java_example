package quiz;

import java.util.Scanner;

/*
 * Scanner 이용.
정수형 변수 enemyHealthPoint 를 만들고 Scanner의 nextInt() 함수를 이용해 값을 할당한다.
무한히 반복을 하면서 난수를 생성해 enemyHealthPoint의 값을 감소 시킨다.
만약 enemyHealthPoint의 값이 0이 되거나 음수가 되면 "Victory!" 를 출력하며 반복문을 종료한다.
 */
public class Quiz20 {
	private int enemyHealthPoint;

	public Quiz20() {
		Scanner scanner = new Scanner(System.in);

		this.enemyHealthPoint = scanner.nextInt();
		scanner.close();
	}
	
	public void startGame() {
		while (true) {
			if(enemyHealthPoint <= 0) {
				System.out.println("Victory!");
				break;
			}
			
			int num = (int) (Math.random() * 100);
			enemyHealthPoint -= num;
			System.out.println("피 감소: -" + num);
		}
	}
	
	
	
	
	public static void main(String[] args) {
		Quiz20 quiz20 = new Quiz20();
		quiz20.startGame();
	}
}
