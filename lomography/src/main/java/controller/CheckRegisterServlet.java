package controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BO.userBO;
import model.Bean.User;

@WebServlet("/CheckRegisterServlet")
public class CheckRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CheckRegisterServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String fullname = request.getParameter("fullname");
		String email = request.getParameter("email");
		
		if(userBO.isExistUser(username, password)) {
			response.sendRedirect("register.jsp");
		}
		else {
			userBO.addUser(fullname, email, username, password);
			User user = userBO.getUser(username, password);
			new File(this.getServletContext().getRealPath("/") + "/user/" + user.getUsername() + "/post").mkdirs();
			
			request.getSession().setAttribute("user", user);
			response.sendRedirect("LoginEntranceServlet");
		}
	}

}
