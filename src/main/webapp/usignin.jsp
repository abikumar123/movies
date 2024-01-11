<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="SaveUser" method="post">

		ID<input name="userid" type="number" pattern="[0-9] {3}"
			placeholder="enter the id of an user" autofocus="autofocus"
			required="required"><br> Name <input name="username"
			type="text" placeholder="enter your name" required="required"><br>
		Mobile No.<input name="usercontact" type="number" pattern="[0-9] {10}"
			placeholder="enter the mobile number" required="required"><br>
		Email<input name="usermail" type="email"
			placeholder="enter valid email address" required="required"><br>
		Password<input name="userpassword" type="password"
			placeholder="(must have one special char&num)"><br> <input
			type="checkbox" required="required"> have accept all the
		terms&conditions.<br> <input type="submit"><br>

	</form>
</body>
</html>