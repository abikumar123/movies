<%@page import="java.util.Base64"%>
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

<% Movie m=(Movie)request.getAttribute("m");%>

<%String base64image =new String(Base64.getEncoder().encode(m.getMovieimage())); %>
				<img src="data:image/jped;base64,<%=base64image %>"
					height="300px" width="300px">
					
					<p>m</p>

</body>
</html>