<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page import="java.util.*,com.bankApplication.model.*" %>
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
		<script src="https://cdn.tailwindcss.com"></script>
</head>
<body>

<div class="bg-blue-300 h-screen w-screen flex items-center justify-center">
 <div>
<a href="createCustomer.jsp">create</a>
<a href="modifyIntro.jsp">modify</a>
<a href="deleteIntro.jsp">delete</a>
<a href="singleCustomer.jsp">View Customer</a>
	<form method=post action="display" >
	<button type="submit">view</button>
	</form>
<a href="adminLogout.jsp">Logout</a>
</div>
</div>

</body>
</html>