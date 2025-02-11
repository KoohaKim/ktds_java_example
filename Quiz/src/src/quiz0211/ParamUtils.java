package quiz0211;

import quiz0211.exception.InvalidMoneyException;

public class ParamUtils {

	public static void checkValidMoney(int money) {
		if(money <= 0) {
			throw new InvalidMoneyException("금액은 0 이하 일 수 없습니다.");
		}
	}
}
