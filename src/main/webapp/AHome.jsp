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

<style type="text/css">


td{
text-align: center;
padding: 25px;

}
img:hover {
	  background-color: red;
}

</style>
</head>
<body>
	<p>welcome to admin home page</p>

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
				<td>Description</td>
				<td>link</td>
				<td>delete</td>
				<td>edit</td>
				

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
					<td><%= movie.getMovieDescription() %></td>
					<td><%= movie.getMovielink() %></td>

				<td><a href="deletemovie?id=<%=movie.getMovieid() %>">delete</a></td>
				<td><a href="movieedit?id=<%=movie.getMovieid() %>">edit</a></td>
				
				


			</tr>
			<%}%>

		</tbody>

	</table>

	<a href="addmovie.jsp">addmovie</a><br>
	<a href="logout">Logout</a><br>
</body>
</html>