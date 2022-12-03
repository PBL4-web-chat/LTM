package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UserAvatarServlet")
public class UserAvatarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UserAvatarServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		File file = new File(getServletContext().getRealPath("/") + "/user/profilePicture/default-avatar.jpg");
		try {
			FileInputStream fis = new FileInputStream(file);
			byte[] fileContent = fis.readAllBytes();
			response.setContentType("image/jpg");
			response.setContentLength(fileContent.length);
			response.getOutputStream().write(fileContent);
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
