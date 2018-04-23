package ro.mindit.dao;

import java.util.List;

import ro.mindit.model.User;

public interface UserDAO {

	public List<User> listUsers();
	
	public void addUser(User user);
	
	public boolean userExists(String username, String password);
}
