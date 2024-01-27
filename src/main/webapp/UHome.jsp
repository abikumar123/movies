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

<style type="text/css">

table {
	padding: 10px;
	height: 100vh;

}
#heading{
font-size:28px;
color: red;
}
td{
text-align: center;
padding: 25px;

}
body{
justify-content: center;
display: flex;
background-color: rgba(0 0 100);
}
td{
font-size:20px;  
}
.image img {
	overflow: hidden;
	position: relative;
}

.image:hover {
	transform: scale(1.5);
	z-index: 2;
}

</style>
</head>
<body>
	
	<% HttpSession s=request.getSession(); %>
	<%List<Movie> movies=(List)s.getAttribute("movies"); %>

	<table border="2px" class="table">
		<thead>
			<tr id="heading">

				<th>Movieid</th>
				<th>MovieName</th>
				<th>MoviePrice</th>
				<th>MovieRating</th>
				<th>MovieGenre</th>
				<th>MovieLanguage</th>
				<th>MovieImage</th>
				<th>BuyMovie</th>
				

			</tr>
		</thead>

		<tbody>

			<%for(Movie movie:movies){ %>

			<tr >

				<td><%= movie.getMovieid() %></td>
				<td><%=movie.getMoivename() %></td>
				<td><%=movie.getMovieprice() %></td>
				<td><%= movie.getMovierating()%></td>
				<td><%= movie.getMoviegenre()%></td>
				<td><%= movie.getMovielanguage()%></td>
				<%String base64image =new String(Base64.getEncoder().encode(movie.getMovieimage())); %>
				<td><img src="data:image/jped;base64,<%=base64image %>"
					height="100px" width="100px" class="image"></td>

				<td><a href="buymovie?id=<%=movie.getMovieid()%>">buy</a></td>


			</tr>
			<%}%>

		</tbody>

	</table>
	<div>
	<br>
	<br>
	<%String msg=(String)request.getAttribute("moviemessage"); %>
	<%if(msg!=null){ %>
	<%= msg %>
	<%} %>
	
	<a href="watchmovies">Watch Movies</a><br>
	<a href="userlogout">Logout</a><br>
	</div>
	
</body>
</html>