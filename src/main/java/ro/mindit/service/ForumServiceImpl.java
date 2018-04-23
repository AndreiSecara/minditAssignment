package ro.mindit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.mindit.dao.ForumDAO;
import ro.mindit.model.Forum;

@Service
public class ForumServiceImpl implements ForumService {
	ForumDAO forumDAO;
	
	@Autowired
	public void setUserDAO(ForumDAO forumDAO) {
		this.forumDAO = forumDAO;
	}
	
	public List<Forum> listForums() {
		return forumDAO.listForums();
	}

	public void addForum(Forum forum) {
		forumDAO.addForum(forum);
	}

	public void editForum(Forum forum) {
		
	}
	
	public Forum getForumById(int id) {
		
		return forumDAO.getForumById(id);
	}

	public void deleteForum(int id) {
		forumDAO.deleteForum(id);
	}

	public boolean forumExists(String name) {
		return forumDAO.forumExists(name);
	}

}
