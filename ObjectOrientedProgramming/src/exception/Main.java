package exception;

public class Main {
	public static void main(String[] args) {
		InvalidUserIdException iuie = new InvalidUserIdException("사용할 수 없는 아이디 입니다. 다른 아이디를 사용해 주세요."); //RuntimeException 상속받은 클래스
//		System.out.println(iuie.getMessage());	//app이 안 죽음
		
//		throw iuie; 							//app이 죽음
		
//		throw new InvalidUserIdException("message");
		
		try {
			registNewMember("1", "aaaa");
			registNewMember("2", "ssss");
			registNewMember("3", "dddd");
			registNewMember("4", "ffff");
			registNewMember(null, "ffff"); // 실패 사유: 아이디 왜 입력 안하세요^^?? 🤬
			
		} catch (InvalidUserIdException e) {
			System.out.println("실패 사유: " + e.getMessage());
	
		}
		
		
	}
		
	
	
	public static void registNewMember(String id, String password) {
		if(id == null || id.isEmpty()) {
			throw new InvalidUserIdException("아이디 왜 입력 안하세요^^?? 🤬");
			
		}else if (id.equals("admin")) {
			throw new InvalidUserIdException("admin은 사용 불가용 ㅋ");
			
		}else {
			System.out.printf("아이디: %s, 비밀번호: %s. 가입 완료ㅋ \n", id, password);
			
		}
	}
	
	
	
}
