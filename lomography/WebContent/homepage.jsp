<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="model.Bean.Posts"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Bean.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
	<title>homepage</title>
</head>
<body>
	<% 
	User user = (User)request.getSession().getAttribute("user"); 
	ArrayList<Posts> posts = (ArrayList<Posts>)request.getSession().getAttribute("demoPosts");
	%>
	<header class="position-sticky">
		<div class="w-100 d-flex">
			<div class="p-2">logo</div>
			<% if(user == null) { %>
			<div class="ms-auto p-2"> 
				<a href="login.jsp" class="text-decoration-none">login</a>
				/
				<a href="register.jsp" class="text-decoration-none">register</a>	
			</div>
			<% } else { %>
			<div class="ms-auto p-2">Hello, user</div>
			<% } %>
			<div class="p-2">
				<a href="UploadPageRedirect" class="p-1 text-decoration-none" style="border: 2px solid gray; border-radius: 3px">Submit a photo</a>
			</div>
		</div>
		<% if(user != null){ %><a href="ProfileRedirect">To Profile</a> <% } %>
	</header>
	<div class="container">
		<% for(Posts p : posts){ %>
			<img src="PostImageServlet?post_id=<%=p.getPost_id()%>">
		<% } %>
	</div>
</body>
</html>