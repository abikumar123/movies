<%@page import="dao.Dao"%>
<%@page import="java.util.Base64"%>
<%@page import="dto.Movie"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<style type="text/css">

body {
	text-align: center;
	text-shadow: black;
	font-size: 30px;
	
}
</style>
<title>Insert title here</title>
</head>
<body>
<%int id=Integer.parseInt(request.getParameter("mid")) ;%>
<% Dao dao=new Dao();%>
<%Movie movie=dao.findByMovieId(id); %>

<%String base64image =new String(Base64.getEncoder().encode(movie.getMovieimage())); %>
				<img src="data:image/jped;base64,<%=base64image %>"
					height="500px" width="500px">
					<br>
		<%= movie.getMovieDescription()%>

</body>
</html>