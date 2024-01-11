<%@page import="dto.Movie"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="checkpay?movie=<%=request.getAttribute("movie")%>">

Enter amount to pay<input placeholder="you need to pay <%=request.getAttribute("price")%>" name="Uprice" type="number"><br>

<input type="submit" >pay amount


</form>

<%String msg=(String)request.getAttribute("message"); %>
	<%if(msg!=null){ %>
	<%= msg %>
	<a href="UHome.jsp">home</a>
	<%} %>
</body>
</html>