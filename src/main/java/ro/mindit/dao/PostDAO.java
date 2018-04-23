package ro.mindit.dao;

import java.util.List;
import ro.mindit.model.Post;

public interface PostDAO {
	
	public List<Post> listPosts(int id);
	
	public void addPost(Post post);

}
