<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>register</title>
</head>
<body>
	<form action="CheckRegisterServlet" method="post">
		<input type="text" name="username" placeholder="username">
		<input type="password" name="password" placeholder="password">
		<input type="text" name="fullname" placeholder="fullname">
		<input type="text" name="email" placeholder="email">
		<input type="submit" value="register">
	</form>
</body>
</html>