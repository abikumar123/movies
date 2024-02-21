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

#head{
   text-align : center ;
}
table {
	padding: 10px;
	height: 100vh;
}

#heading {
	font-size: 28px;
	color: red;
}

td {
	text-align: center;
	padding: 25px;
}


}

td {
	font-size: 20px;
}

.image img {
	overflow: hidden;
	position: relative;
}

.image:hover {
	transform: scale(1.5);
	z-index: 2;
}
#user-funtion{
      text-align : center ;
}
#cart{
   
}
#watch{
   background-color : blue ;  
}
#log{
    
}



</style>
</head>
<body>

	<%
	HttpSession s = request.getSession();
	%>
	<%
	List<Movie> movies = (List) s.getAttribute("movies");
	%>
	<div  id="head">
		<h1>WELCOME TO HOME PAGE</h1>
	</div>
	
	<br>
	
	<div>
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
					<th>Cart</th>
					<th>BuyMovie</th>


				</tr>
			</thead>

			<tbody>

				<%
				for (Movie movie : movies) {
				%>

				<tr>

					<td><%=movie.getMovieid()%></td>
					<td><%=movie.getMoivename()%></td>
					<td><%=movie.getMovieprice()%></td>
					<td><%=movie.getMovierating()%></td>
					<td><%=movie.getMoviegenre()%></td>
					<td><%=movie.getMovielanguage()%></td>
					<%
					String base64image = new String(Base64.getEncoder().encode(movie.getMovieimage()));
					%>
					<td><img src="data:image/jped;base64,<%=base64image%>"
						height="100px" width="100px" class="image"></td>


					<%
					String cartmessage = (String) request.getAttribute("cartmessage");
					%>

					<td>
					<a href="addcart?id=<%= movie.getMovieid() %>">add to cart</a>
					</td>
					<td><a href="buymovie?id=<%= movie.getMovieid() %>">buy</a></td>


				</tr>
				<%
				}
				%>

			</tbody>

		</table>
	</div>

	<div id="user-funtion">
	
	<button id="cart">  <a href="MovieCart">cart <box-icon name='cart-alt'></box-icon></a></button> 
	<br>
	  <button id="watch"><a href="watchmovies">Watch Movies</a></button>
    <br>
	<button id="log"> <a href="userlogout">Logout</a><br></button>	
		
	</div>


	<div>
		<%
		String msg = (String) request.getAttribute("moviemessage");
		%>
		<%
		if (msg != null) {
		%>
		<%=msg%>
		<%
		}
		%>
		<%
		String cartmessage = (String) request.getAttribute("cartmessage");
		%>
		<%
		if (cartmessage != null) {
		%>
		<%=cartmessage%>
		<%
		}
		%>
	</div>

	

</body>
</html>