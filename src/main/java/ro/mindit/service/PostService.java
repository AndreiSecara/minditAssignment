package ro.mindit.service;

import java.util.List;

import ro.mindit.model.Post;

public interface PostService {

	public List<Post> listPosts(int id);

	public void addPost(Post post);

}
