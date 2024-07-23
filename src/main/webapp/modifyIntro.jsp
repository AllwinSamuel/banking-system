<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% if(session.getAttribute("adminId")==null){
	response.sendRedirect("login.jsp");
} %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/sweetalert2@11/dist/sweetalert2.min.css">
 <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11/dist/sweetalert2.all.min.js"></script>
</head>
<body>
<form action="modify" method=post>
<input
     type = number
     placeholder="Enter Account Number"
     required
     name="ano"  
>
 <button type="submit">Search</button>
</form>
</body>
</html>