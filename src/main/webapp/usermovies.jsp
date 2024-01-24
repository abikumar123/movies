<%@page import="java.util.Base64"%>
<%@page import="dto.Movie"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<%List<Movie> umovies=(List)request.getAttribute("usermovies"); %>
	
	<table>
	
	<%for(Movie movie:umovies){ %>
	
	<tr> 
	<%String base64image =new String(Base64.getEncoder().encode(movie.getMovieimage())); %>
				<td><img src="data:image/jped;base64,<%=base64image %>"
					height="200px" width="150px"></td>
					
					<td><a href="watchmovie.jsp?mid=<%=movie.getMovieid() %>">watch movie</a></td>
					
					
	 </tr>
	
	<%} %>
	
	
	</table>
	
</body>
</html>