package quiz0214;

import java.util.List;

public interface PostManager {
	
	List<Post> findAllPosts();
	
	Post findPost(int postId);
	
	Post createPost(Post post);
	
	Post modifyPost(int postId);
	
	void removePost(int postId);
	
}
