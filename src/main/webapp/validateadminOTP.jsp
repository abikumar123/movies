<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

 <form action="validateadminotp">
   
   <h4>YOUR OTP IS</h4>
   <%int otp=(int)request.getAttribute("otp"); %>
   <h2><%=otp %></h2>
   
  enter the otp  <input type="number" name="adminotp">
  
  <% request.setAttribute("ootp", otp); %>
  <input  type="submit">
   
   
   </form>


</body>
</html>