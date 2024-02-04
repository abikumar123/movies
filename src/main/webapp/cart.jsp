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

<%
	List<Movie> movies = (List) request.getAttribute("cartmovies");
	%>
	
	
	<%if(movies!=null){ %>
	
	<table>
	
	<thead>
	   <tr>
	   <th>Movie Name</th>
	   <th>Image</th>
	   <th>price</th>
	   <th>buy</th>
	   <th>remove</th>
	   
	   </tr>
	</thead>
	<tbody>
	<%for(Movie movie:movies){ %>
	</tbody>
	            <tr>

					
					<td><%=movie.getMoivename()%></td>
					
					<%
					String base64image = new String(Base64.getEncoder().encode(movie.getMovieimage()));
					%>
					<td><img src="data:image/jped;base64,<%=base64image%>"
						height="100px" width="100px" class="image"></td>

                    <td><%=movie.getMovieprice()%></td>
					<td><a href="buymovie?id=<%= movie.getMovieid() %>">buy</a></td>
					<td><a href="removemovie?id=<%= movie.getMovieid() %>">remove</a></td>


				</tr>
				<%
				}
				%>
	
	</table>
	<%}else{ %>
	<p>you don't added any movies to the cart yet</p>
	<%} %>
	
	<a href="UHome.jsp">return to home</a>

</body>
</html>