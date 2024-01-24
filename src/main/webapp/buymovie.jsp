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
<%HttpSession s=request.getSession(); %>
<%  Movie m=(Movie)s.getAttribute("movie");%>

<form action="checkpay">

Enter amount to pay<input placeholder="you need to pay <%=m.getMovieprice() %>" name="Uprice" type="number"><br>

<input type="submit" >pay amount
<%request.setAttribute("m", m); %>

</form>

<%String msg=(String)request.getAttribute("message"); %>
	<%if(msg!=null){ %>
	<%= msg %>
	<%request.setAttribute("movies", request.getAttribute("movies")); %>
	<a href="UHome.jsp">home</a>
	<%} %>
</body>
</html>