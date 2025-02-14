package quiz0214;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Comment {
	private String content;
	private String writer;
	private String createdDate;
	private String createdTime;
	
	public Comment(String content, String userName) {
		this.content = content;
		this.writer = userName;
		this.createdDate = DateTimeFormatter.ofPattern("yyyy년 MM읠 dd일").format(LocalDateTime.now());
		this.createdTime = DateTimeFormatter.ofPattern("HH시 mm분 ss초").format(LocalTime.now());
	}
	
	
	
}
