package model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import model.Bean.Posts;

public class postDAO {

	public static ArrayList<Posts> getAllPost() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lomography", "root", "");

			Statement stt = cnn.createStatement();
			ResultSet rs = stt
					.executeQuery("SELECT * FROM Post INNER JOIN User on User.user_id = Post.user_id limit 9");

			ArrayList<Posts> posts = new ArrayList<Posts>();
			while (rs.next()) {
				Posts post = new Posts();

				post.setPost_id(rs.getInt(1));
				post.setTitle(rs.getString(2));
				post.setPath(rs.getString(3));
				post.setDescription(rs.getString(4));
				post.setUploadDate(rs.getDate(5));
				post.setUser_id(rs.getInt(6));
				post.setUsername(rs.getString(7));

				posts.add(post);
			}
			return posts;
		} catch (Exception e) {
		}
		return null;
	}

	public static ArrayList<Posts> getAllPostOfId(int user_id) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lomography", "root", "");

			Statement stt = cnn.createStatement();
			String query = "SELECT * FROM Post INNER JOIN User on User.user_id = Post.user_id WHERE Post.user_id = "
					+ user_id + " LIMIT 9";
			ResultSet rs = stt
					.executeQuery(query);
			
			ArrayList<Posts> posts = new ArrayList<Posts>();
			while (rs.next()) {
				Posts post = new Posts();

				post.setPost_id(rs.getInt(1));
				post.setTitle(rs.getString(2));
				post.setPath(rs.getString(3));
				post.setDescription(rs.getString(4));
				post.setUploadDate(rs.getDate(5));
				post.setUser_id(rs.getInt(6));
				post.setUsername(rs.getString(7));

				posts.add(post);
			}
			return posts;
		} catch (Exception e) {
		}
		return null;
	}

	public static Posts getPostById(int id) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lomography", "root", "");

			Statement stt = cnn.createStatement();
			ResultSet rs = stt.executeQuery(
					"SELECT post_id, title, path, description, uploadDate, Post.user_id, User.username FROM Post INNER JOIN User on User.user_id = Post.user_id WHERE post_id = "
							+ id);

			rs.next();
			Posts post = new Posts();

			post.setPost_id(rs.getInt(1));
			post.setTitle(rs.getString(2));
			post.setPath(rs.getString(3));
			post.setDescription(rs.getString(4));
			post.setUploadDate(rs.getDate(5));
			post.setUser_id(rs.getInt(6));
			post.setUsername(rs.getString(7));

			return post;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void addPost(String title, String pathInDB, String description, int user_id) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lomography", "root", "");

			Statement stt = cnn.createStatement();

			String query = "INSERT INTO `Post`(`title`, `path`, `description`, `uploadDate`, `user_id`) VALUES ('"
					+ title + "','" + pathInDB + "','" + description + "','" + LocalDate.now().toString() + "', "
					+ user_id + ")";
			stt.executeUpdate(query);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void DeletePost(int id) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lomography", "root", "");

			Statement stt = cnn.createStatement();

			String query = "DELETE FROM Post WHERE post_id = " + id;
			stt.executeUpdate(query);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}