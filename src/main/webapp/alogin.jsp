<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
#form {
	background-color: purple;
	text-align: center;
}
</style>
</head>
<body>

	<h3>welcome to login page</h3>
	<br>
	<form action="alogin" method="post" id="form">

		<input type="email" placeholder="enter the maild id" name="mail"><br>
		<input type="password" placeholder="neter the password"
			name="password"><br> <input type="submit">
	</form>


	<%String msg=(String)request.getAttribute("message"); %>
	<%if(msg!=null){ %>
	<%= msg %>
	<%} %>



</body>
</html>