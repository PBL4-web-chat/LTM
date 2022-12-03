package model.BO;

import model.Bean.User;
import model.DAO.userDAO;

public class userBO{

	public static User getUser(String username, String password) {
		return userDAO.getUser(username, password);
	}

	public static User getUserById(int uid) {
		return userDAO.getUserById(uid);
	}

	public static boolean isExistUser(String username, String password) {
		User user = getUser(username, password);
		if(user == null) return false;
		return true;
	}

	public static void addUser(String fullname, String email, String username, String password) {
		userDAO.AddUser(fullname, email, username, password);
	}

	
}