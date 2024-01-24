<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3>welcome to user login page</h3>
	<br>
	<form action="ulogin" method="post">

		<input type="email" placeholder="enter the maild id" name="mail"><br>
		<input type="password" placeholder="enter the password"
			name="password"> <br> <input type="submit"><br>
	</form>

	<%String msg=(String)request.getAttribute("message"); %>
	<%if(msg!=null){ %>
	<%= msg %>
	<%} %>

</body>
</html>