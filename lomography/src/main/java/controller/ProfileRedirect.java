package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BO.postBO;
import model.Bean.Posts;
import model.Bean.User;

@WebServlet("/ProfileRedirect")
public class ProfileRedirect extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ProfileRedirect() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = (User)request.getSession().getAttribute("user");
		ArrayList<Posts> userPosts = postBO.getPostsOfUser(user.getUser_id());
		request.getSession().setAttribute("userPosts", userPosts);
		response.sendRedirect("profile.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
