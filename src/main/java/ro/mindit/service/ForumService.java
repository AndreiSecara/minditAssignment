package ro.mindit.service;

import java.util.List;

import ro.mindit.model.Forum;

public interface ForumService {
	public List<Forum> listForums();

	public void addForum(Forum forum);

	public void editForum(Forum forum);
	
	public Forum getForumById(int id);

	public void deleteForum(int id);

	public boolean forumExists(String name);

}
