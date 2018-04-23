package ro.mindit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.mindit.dao.UserDAO;
import ro.mindit.model.User;

@Service
public class UserServiceImpl implements UserService {

	UserDAO userDAO;

	@Autowired
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public List<User> listUsers() {
		return userDAO.listUsers();
	}

	public void addUser(User user) {
		userDAO.addUser(user);
	}

	public boolean userExists(String user_name, String password) {
		return userDAO.userExists(user_name, password);
	}

}
