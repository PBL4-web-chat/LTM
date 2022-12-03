package model.BO;

import java.util.ArrayList;

import model.Bean.Posts;
import model.DAO.postDAO;

public class postBO{

	public static ArrayList<Posts> getAllPost() {
		return postDAO.getAllPost();
	}

	public static String getPathOfId(int id) {
		return postDAO.getPostById(id).getPath();
	}

	public static void addPost(String title, String pathInDB, String description, int user_id) {
		postDAO.addPost(title, pathInDB, description, user_id);
	}

	public static ArrayList<Posts> getPostsOfUser(int user_id) {
		return postDAO.getAllPostOfId(user_id);
	}
	
}