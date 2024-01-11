<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@page import="java.util.Base64"%>
<%@page import="dto.Movie"%>
<%@page import="java.util.List"%>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>welcome to user home page</p>
	
	<%List<Movie> movies=(List)request.getAttribute("movies"); %>

	<table border="2px" class="table">
		<thead>
			<tr>

				<td>Movieid</td>
				<td>MovieName</td>
				<td>MoviePrice</td>
				<td>MovieRating</td>
				<td>MovieGenre</td>
				<td>MovieLanguage</td>
				<td>MovieImage</td>
				<td>BuyMobie</td>
				

			</tr>
		</thead>

		<tbody>

			<%for(Movie movie:movies){ %>

			<tr>

				<td><%= movie.getMovieid() %></td>
				<td><%=movie.getMoivename() %></td>
				<td><%=movie.getMovieprice() %></td>
				<td><%= movie.getMovierating()%></td>
				<td><%= movie.getMoviegenre()%></td>
				<td><%= movie.getMovielanguage()%></td>
				<%String base64image =new String(Base64.getEncoder().encode(movie.getMovieimage())); %>
				<td><img src="data:image/jped;base64,<%=base64image %>"
					height="100px" width="100px"></td>

				<td><a href="buymovie?id=<%=movie.getMovieid()%>">buy</a></td>


			</tr>
			<%}%>

		</tbody>

	</table>
	
</body>
</html>