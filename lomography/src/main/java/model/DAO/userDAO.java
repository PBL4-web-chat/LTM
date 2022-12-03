package model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import model.Bean.User;

public class userDAO {

	public static User getUser(String username, String password) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lomography", "root", "");

			Statement stt = cnn.createStatement();
			ResultSet rs = stt.executeQuery(
					"SELECT * FROM User WHERE username= '" + username + "' AND password = '" + password + "'");

			rs.next();
			if (rs != null) {
				User user = new User();

				user.setUser_id(rs.getInt(1));
				user.setFullname(rs.getString(2));
				user.setEmail(rs.getString(3));
				user.setUsername(rs.getString(4));
				user.setPassword(rs.getString(5));
				user.setRole(rs.getInt(6));
				user.setProfilePicture(rs.getString(7));

				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public static User getUserById(int uid) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lomography", "root", "");

			Statement stt = cnn.createStatement();
			ResultSet rs = stt.executeQuery("SELECT * FROM User WHERE user_id = " + uid);

			rs.next();
			if (rs != null) {
				User user = new User();

				user.setUser_id(rs.getInt(1));
				user.setFullname(rs.getString(2));
				user.setEmail(rs.getString(3));
				user.setUsername(rs.getString(4));
				user.setPassword(rs.getString(5));
				user.setRole(rs.getInt(6));
				user.setProfilePicture(rs.getString(7));

				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void AddUser(String fullName, String email, String username, String password) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lomography", "root", "");

			Statement stt = cnn.createStatement();
			stt.executeUpdate(
					"INSERT INTO `User`(`fullname`, `email`, `username`, `password`, `role`, `profilePicture`) VALUES ('"
							+ fullName + "','" + email + "','" + username + "','" + password
							+ "', 1, 'user/profilePicture/default-avatar.jpg')");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void UpdateUser(User user) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lomography", "root", "");

			Statement stt = cnn.createStatement();
			stt.executeUpdate("UPDATE User SET fullname = '" + user.getFullname() + "', email = '" + user.getEmail()
					+ "', username = '" + user.getUsername() + "', password = '" + user.getPassword() + "', role = "
					+ user.getRole() + ", profilePicture = '" + user.getProfilePicture() + "'");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}