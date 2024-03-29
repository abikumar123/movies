<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
body {
    font-family: 'Arial', sans-serif;
    margin: 0;
    padding: 0;
    background-color: #f0f0f0; /* Set a background color for the entire page */
}

.selection-container {
    text-align: center;
    margin-top: 100px;
}

/* Styling for User Selection */
.user-selection {
    display: inline-block;
    padding: 15px 30px;
    text-decoration: none;
    color: #fff; /* Text color */
    background-color: #3498db; /* Background color for User */
    border-radius: 5px;
    font-size: 18px;
    margin-right: 20px;
}

/* Styling for Admin Selection */
.admin-selection {
    display: inline-block;
    padding: 15px 30px;
    text-decoration: none;
    color: #fff; /* Text color */
    background-color: #e74c3c; /* Background color for Admin */
    border-radius: 5px;
    font-size: 18px;
}

/* Hover effect for both selections */
.user-selection:hover,
.admin-selection:hover {
    opacity: 0.8;
    transition: 0.3s;
}

</style>
</head>
<body>
	  <div class="selection-container">
        <a href="ulogin.jsp" class="user-selection">login</a>
        <a href="usignin.jsp" class="admin-selection">signin</a>
    </div>
</body>
</html>