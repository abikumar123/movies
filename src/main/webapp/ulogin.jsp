<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f4f4f4;
	background-image: url("ASSETS/multi-movie-bg.jpg");
	background-repeat: no-repeat;
	background-size: cover;
	margin: 0;
	display: flex;
	align-items: center;
	justify-content: center;
	height: 100vh;
}

.login-container {
	background-color: #fff;
	border-radius: 8px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
	padding: 20px;
	width: 300px;
	text-align: center;
}

.login-container h2 {
	margin-bottom: 20px;
}

.form-group {
	margin-bottom: 20px;
}

.form-group label {
	display: block;
	margin-bottom: 5px;
	font-weight: bold;
}

.form-group input {
	width: 100%;
	padding: 8px;
	box-sizing: border-box;
	border: 1px solid #ccc;
	border-radius: 4px;
}

.login-btn {
	background-color: #4caf50;
	color: #fff;
	padding: 10px 20px;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}

.login-btn:hover {
	box-shadow: 0 0 30px #2dfd34;
}

p {
	text-align: center;
	color: red;
}

</style>
</head>
<body>


	<br>
	<form action="ulogin" method="post">

		<div class="login-container">
			<h2>Login Page</h2>

			<div class="form-group">
				<label for="username">Username:</label> <input type="text"
					id="username" name="mail" required>
			</div>
			<div class="form-group">
				<label for="password">Password:</label> <input type="password"
					id="password" name="password" required>
			</div>
			<div>
				<button type="submit" class="login-btn">Get Otp</button>
			</div>

			<div>
				<%
				String msg = (String) request.getAttribute("message");
				%>
				<%
				if (msg != null) {
				%>
				<h2><%=msg%></h2>
				<%
				}
				%>
			</div>
		</div>


	</form>





</body>
</html>