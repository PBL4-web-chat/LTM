package controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import model.BO.postBO;
import model.BO.userBO;
import model.Bean.User;

@WebServlet("/UploadHandleServlet")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, maxFileSize = 1024 * 1024 * 50, maxRequestSize = 1024 * 1024 * 50)
public class UploadHandleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UploadHandleServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int uid = Integer.parseInt(request.getParameter("uid"));
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		User user = userBO.getUserById(uid);
		
		String PathInDB = "";
		for (Part part : request.getParts()) {
			String fileName = extractFileName(part);
			// refines the fileName in case it is an absolute path
			fileName = new File(fileName).getName();
			if(fileName == "") continue;
			
			PathInDB = "user/" + user.getUsername() + "/post/" + fileName;
			String filePath = this.getServletContext().getRealPath("/") + "/" + PathInDB;
			
			if(new File(filePath).exists()) {
				int i = 0;
				PathInDB = PathInDB.substring(0, PathInDB.length() - 4);
				String name = filePath.substring(0, filePath.length() - 4);
				String extension = filePath.substring(filePath.length() - 4);
				while(true) {
					i++;
					String newPath = name + i + extension;
					if(new File(newPath).exists()) {
						continue;
					}
					else {
						PathInDB += i + extension;
						part.write(newPath);
						break;
					}
				}
			}
			else {
				part.write(filePath);
			}
		}
		
		postBO.addPost(title, PathInDB, description, user.getUser_id());
		response.sendRedirect("homepage.jsp");
	}

	private String extractFileName(Part part) {
		String contentDisp = part.getHeader("content-disposition");
		String[] items = contentDisp.split(";");
		for (String s : items) {
			if (s.trim().startsWith("filename")) {
				return s.substring(s.indexOf("=") + 2, s.length() - 1);
			}
		}
		return "";
	}

	public File getFolderUpload() {
		File folderUpload = new File("C:\\demo");
		if (!folderUpload.exists()) {
			folderUpload.mkdirs();
		}
		return folderUpload;
	}
}
