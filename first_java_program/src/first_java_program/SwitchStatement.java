package first_java_program;

public class SwitchStatement {

	public static void main(String[] args) {
	
		int step = 1;
		
		switch(step) {
		case 1:
			System.out.println("1. 수납장을 손잡이를 손으로 잡아 문을 당겨서 연다.");
		case 2:
			System.out.println("2. 수납장에서 냄비의 손잡이 부분을 손으로 잡아 수납장 밖으로 꺼낸다.");
		case 3:
			System.out.println("3. 냄비를 세척해야 할지 보고 판단한다.");
		case 4:
			int randomNum = (int)(Math.random() * 10);
			if (randomNum % 2 == 0) {
				System.out.println("4. 냄비가 깨끗하다면 가스레인지에 올린다.");
			}else if (randomNum == 9) {
				System.out.println("4. 냄비를 씻다가 떨어뜨려 깨져버렸습니다;;");
				break;
			}
				System.out.println("4. 냄비가 더럽다면 씻어서 가스레인지에 올린다.");		
		case 5:
			System.out.println("5. 냉장고로 걸어가 냉장실 문을 열어 손으로 생수를 집어서 냄비 앞으로 간다. 손으로 생수의 뚜껑을 열고 냄비에 물을 550ml 붓는다");
		case 6:
			System.out.println("6. 냄비가 올라간 가스레인지의 레버를 잡고 돌려서 불을 킨다");
		case 7:
			System.out.println("7. 수납장으로 가서 손잡이를 잡아 문을 당겨서 열어 라면을 손으로 집어서 꺼내 가스레인지 앞으로 돌아간다");
		case 8:
			System.out.println("8. 라면 봉지를 조심히 뜯는다.");
		case 9:
			System.out.println("9. 후레이크 스프를 꺼내 뜯어 냄비에 내용물만 털어 넣는다.");
		case 10:
			System.out.println("10. 냄비의 물이 끓으면 봉지에 남아 있는 면을 꺼내 냄비에 넣는다.");
		case 11:
			System.out.println("11. 분말스프를 거내 뜯어 냄비에 내용물을 붓는다.");
		case 12:
			System.out.println("12. 정해진 시간을 지켜 기다린다.");
		case 13:
			System.out.println("13. 시간이 지나고 나면 가스레인지의 레버를 돌려 불을 끈다.");
		case 14:
			System.out.println("14. 수납장으로 가 손잡이 부분을 손으로 잡아 그릇을 찾아 손으로 집어 식탁에 놓는다.");
		case 15:
			System.out.println("15. 수저를 찾는다");
		case 16:
			System.out.println("16. 수저를 식탁에 놓는다.");
		case 17:
			System.out.println("17. 냄비를 가스레인지에 옮겨 내용물을 그릇에 붓는다.");
		case 18:
			System.out.println("18. 맛있게 먹는다.");
			
		}
		
	//라면 끓이기 절차 출력
		

	}
}
