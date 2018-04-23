package ro.mindit.service;

import java.util.List;

import ro.mindit.model.User;

public interface UserService {

	public List<User> listUsers();

	public void addUser(User user);

	public boolean userExists(String user_name, String password);

}
