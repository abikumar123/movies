<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.Base64"%>
<%@page import="dto.Movie"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<%Movie m=(Movie)request.getAttribute("movie"); %>

	<form action="updatemovie" method = "post" enctype="multipart/form-data">
		
      movieid: <input type="number" name="movieid"
		value="<%= m.getMovieid() %>" readonly> <br>
		moviename:<input type="text" name="moviename" autofocus="autofocus"
		value="<%= m.getMoivename() %>"> <br>
		movieprice:<input type="number" name="movieprice"
		value="<%= m.getMovieprice() %>"> <br>
		movierating:<input type="number" name="movierating"
		value="<%= m.getMovierating() %>"> <br>
		moviegenre:<input type="text" name="moviegenre"
		value="<%= m.getMoviegenre() %>"> <br>
		movielanguage: <input type="text" name="movielanguage"
		value="<%= m.getMovielanguage() %>"> <br>
		movieimage:<input type="file" name="movieimage"> <br>
		
		<input type="submit">
	
	<%String base64image=new String(Base64.getEncoder().encode(m.getMovieimage())); %>
	<img src="data:image/jpeg;base64 , <%= base64image %>" height="150px"
		width="100px">
	
	</form>
		
</body>
</html>