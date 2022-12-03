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

@WebServlet("/LoginEntranceServlet")
public class LoginEntranceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginEntranceServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Posts> posts = postBO.getAllPost();
		
		request.getSession().setAttribute("demoPosts", posts);
		
		response.sendRedirect("homepage.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
