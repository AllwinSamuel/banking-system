<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
  if(session.getAttribute("customer")==null){
	  response.sendRedirect("customerLogin.jsp");
  }
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/sweetalert2@11/dist/sweetalert2.min.css">
 <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11/dist/sweetalert2.all.min.js"></script>
</head>
<body>
	<form action="closeAccount" method=post>
	<input
	     type = number
	     placeholder="Enter Account Number"
	     required
	     name="ano"  
	>
	<input 
	     type="text"
	     placeholder="password"
	     required
	     name="password">
	 <button type="submit">Delete</button>
	</form>
</body>
</html>