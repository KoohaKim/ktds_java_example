package quiz0214;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Board// implements PostManager, CommentManager
{
	private Scanner scanner;

	public Board() {
		this.scanner = new Scanner(System.in);
	}

	
	
	public Post createPost() {
		String input = this.scanner.nextLine(); // 하 이 루
		List<String> arr = new ArrayList<>();
		String title;
		String writer;
		String content;

		for (String value : input.split(" ")) {
			arr.add(value);
		}

		while (true) {
			if (arr.get(0) != null && arr.size() > 0 && !arr.get(0).isEmpty()) {
				title = arr.get(0);
			}else {
				System.out.println("제목을 입력하세요: ");
				continue;
			}
			
			if (arr.get(1) != null && arr.size() > 0 && !arr.get(1).isEmpty()) {
				writer = arr.get(1);
			}else {
				System.out.println("작성자를 입력하세요: ");
				continue;
			}
			
			
			if (arr.size() != 3) {
				content = "";
				break;
			}else {
				content = arr.get(2);
				break;
			} 
		}
		return new Post(title, writer, content);
	}

	public static void main(String[] args) {
		Board board = new Board();
		System.out.println(board.createPost());
	}
}
