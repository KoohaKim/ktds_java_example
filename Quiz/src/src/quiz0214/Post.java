package quiz0214;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Post {
	private String title;
	private String createdDate;
	private String createdTime;
	private String writer;
	private String content;
	private List<Comment> comments;
	
	
	public Post(String title,String writer, String contents) {
		this.title = title;
		this.createdDate = DateTimeFormatter.ofPattern("yyyy년 MM읠 dd일").format(LocalDateTime.now());
		this.createdTime = DateTimeFormatter.ofPattern("HH시 mm분 ss초").format(LocalTime.now());
		this.writer = writer;
		this.content = contents;
		this.comments = new ArrayList<>();
	}


	@Override
	public String toString() {
		return "Post [title=" + title + ", createdDate=" + createdDate + ", createdTime=" + createdTime + ", writer="
				+ writer + ", content=" + content + ", comments=" + comments + "]";
	}
	
	
	
	
	
}
