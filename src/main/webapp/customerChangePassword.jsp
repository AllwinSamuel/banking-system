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
<%Long no=(Long)session.getAttribute("customer"); %>

 <form action="changePassword" method="post">
          <input 
		      readonly 
		      placeholder="Account Number"
		      required
		      name="ano"
		      value="<%=no %>"
		  >
		  <input 
		      type="password" 
		      placeholder="Old Password"
		      required
		      name="oldPassword"
		      
		  >
		  <input 
		      type="password" 
		      placeholder="New Password"
		      required
		      name="newPassword"
		      
		  >
		  <button type="submit">Change</button>
  </form>
</body>
</html>