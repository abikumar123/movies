<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

 <style type="text/css">
 

 </style>
</head>
<body>

	<h2>Add Moive</h2>

	<form action="savemovie" method="post" enctype="multipart/form-data">

		movieid <input type="number" name="movieid" autofocus="autofocus"><br>
		moviename <input type="text" name="moviename"><br>
		movieprice <input type="number" name="movieprice"><br>
		movierating <input type="text" name="movierating"><br>
		moviegenre <input type="text" name="moviegenre"><br>
		movielanguage <input type="text" name="movielanguage"><br>
		movieimage<input type="file" name="movieimage"><br> 
		moviedescription<input type="text" name="moviedescription"><br>
		movielink<input type="text" name="movielink"><br>
		<input type="submit">














	</form>

</body>
</html>