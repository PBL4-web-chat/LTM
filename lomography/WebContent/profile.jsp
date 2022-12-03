<%@page import="model.Bean.Posts"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>profile</title>
</head>
<body>
	<% ArrayList<Posts> userPosts = (ArrayList<Posts>)session.getAttribute("userPosts"); %>
	
	<% for(Posts p : userPosts) { %>
		<img src="PostImageServlet?post_id=<%=p.getPost_id() %>">
	<% } %> 
</body>
</html>