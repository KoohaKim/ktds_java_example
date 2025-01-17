package first_java_program;

public class IfStatement {

	public static void main(String[] args) {
		// 커피 가격
		int coffee = 1500;
		int mywallet = (int) (Math.random() * 10000); // 0 ~ 9999
		int friendWallet = (int) (Math.random() * 5000);
		// 내가 커피 5 잔을 사 먹을 수 있을까?
		int totalPrice = coffee * 5;
		boolean canBuy =  totalPrice <= mywallet;
		
		//문제
		// 내가 커피를 사 먹을 수 있으면, "커피, 주문했습니다" 라고 출력, 그리고 내가 가진 돈에서 커피 가격을 뺀다.
		// 내가 커피를 사 먹을 수 없으면, "커피를 주문할 돈이 부족합니다." 를 출력하고 모자란 금액을 출력.
		// 내가 커피를 사 먹을 수 없는데, 친구가 모자란 돈을 가지고 있으면 돈을 빌려서 커피를 주문한다.
		// "친구에게 돈을 빌려서 커피를 주문했습니다." 를 출력하고 빌린 돈을 출력한다.
		if(canBuy) {
			System.out.println("커피, 주문했습니다.");
			System.out.println("지갑 잔고: " + mywallet);
			mywallet -= totalPrice;
			System.out.println("남은 금액: " + mywallet);
			
		}else if (friendWallet >= totalPrice - mywallet) {
			System.out.println("친구 지갑 잔고: " + friendWallet);	
			friendWallet -= (totalPrice-mywallet);
			System.out.println("내 지갑: " + mywallet + "주문 금액: " + totalPrice + "빌려야 하는 금액: " + (totalPrice-mywallet));
			System.out.println("친구에게 돈을 빌려서 커피를 주문 했습니다." + " 친구 지갑 잔고: " + friendWallet);
			
		} else if (friendWallet >= (coffee * 4) - mywallet) {
			System.out.println("친구에게 모자란 돈을 빌려서 4잔을 주문했습니다.");
			int loon = Math.abs((coffee * 4) - mywallet);
			System.out.println("빌린 돈: " + loon);
			
		} else {
			System.out.println("커피를 주문할 돈이 부족합니다. 지갑 잔고:" + mywallet + ", 주문 금액: " + totalPrice);
			System.out.println("친구의 돈도 부족합니다. 친구 지갑 잔고: " + friendWallet );
		}
		
		
		
	}
}
