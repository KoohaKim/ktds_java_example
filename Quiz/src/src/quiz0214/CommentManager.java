package quiz0214;

public interface CommentManager {
	Comment createComment(int postId);
	
	Comment findComment(int commentId);
	
	void removeComment(int commentId);
	
	void powerOff();

	Post createPost();
}
