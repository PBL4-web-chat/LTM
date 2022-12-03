package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BO.postBO;
import model.BO.userBO;
import model.Bean.Posts;
import model.Bean.User;

@WebServlet("/CheckLoginServlet")
public class CheckLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CheckLoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		User user = userBO.getUser(username, password);
		
		if(user != null) {
			ArrayList<Posts> posts = postBO.getAllPost();
			
			request.getSession().setAttribute("user", user);
			request.getSession().setAttribute("demoPosts", posts);
			response.sendRedirect("homepage.jsp");
		}
		else {
			response.sendRedirect("login.jsp");
		}
	}

}
