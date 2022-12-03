<%@page import="model.Bean.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Upload</title>
</head>
<body>
	<% User user = (User)request.getSession().getAttribute("user"); %>
	<form action="UploadHandleServlet?uid=<%=user.getUser_id()%>" method="post" enctype="multipart/form-data">
		<input type="file" name="file" value="select file">
		<input type="text" name="title" placeholder="title">
		<input type="text" name="description" placeholder="description">
		<input type="submit" value="upload">
	</form>
</body>
</html>