package quiz0214;

import java.util.List;

public interface PostManager {
	
	void findAllPosts();
	
	Post findPostById(int postId);
	
	Post createPost();
	
	Post modifyPost();
	
	void removePost(int postId);
	
}
