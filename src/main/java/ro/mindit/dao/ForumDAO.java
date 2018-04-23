package ro.mindit.dao;

import java.util.List;

import ro.mindit.model.Forum;

public interface ForumDAO {

	public List<Forum> listForums();
	
	public void addForum(Forum forum);
	
	public void deleteForum(int id);
	
	public boolean forumExists(String name);

	public Forum getForumById(int id);
}
