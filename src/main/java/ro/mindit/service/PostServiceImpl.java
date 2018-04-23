package ro.mindit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.mindit.dao.PostDAO;
import ro.mindit.model.Post;

@Service
public class PostServiceImpl implements PostService {

	PostDAO postDAO;
	
	@Autowired
	public void setPostDAO(PostDAO postDAO) {
		this.postDAO = postDAO;
	}
	
	public List<Post> listPosts(int id) {
		return postDAO.listPosts(id);
	}

	public void addPost(Post post) {
		postDAO.addPost(post);
		
	}

}
