package quiz0214;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Post {
    private String title;
    private String writer;
    private String content;
    private String createdDate;
    private String createdTime;
    private List<Comment> comments;


    public Post(String title, String writer, String contents) {
        this.title = title;
        this.writer = writer;
        this.content = contents;
        this.createdDate = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일").format(LocalDateTime.now());
        this.createdTime = DateTimeFormatter.ofPattern("HH시 mm분 ss초").format(LocalTime.now());
        this.comments = new ArrayList<>();
    }

    public List<String> convertToList(){
        List<String> postList = new ArrayList<>();
        postList.add(this.writer);
        postList.add(this.content);
        postList.add( this.createdDate);
        postList.add(this.createdTime);
        return postList;
    }


    public String getTitle() {
        return this.title;
    }

    public String getWriter() {
        return this.writer;
    }

    public String getContent() {
        return this.content;
    }

    public String getCreatedDate() {
        return this.createdDate;
    }

    public String getCreatedTime() {
        return this.createdTime;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public List<Comment> getComments() {
        return this.comments;
    }


}
