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
<p><%Long ano=(Long)session.getAttribute("customer"); %></p>

<p><%Long balance=(Long)session.getAttribute("customerBalance"); %></p>

<form action="withdraw" method=post>
 <input 
   readonly
   value="<%=ano%>"
   name="ano"
   >
   <input 
   type="number"
   placeholder="Enter Amount"
   required
   name="balance"
   >
   <button type=submit >Withdraw</button>
</form>
</body>
</html>