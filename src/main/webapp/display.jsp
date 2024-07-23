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
</head>
<body>
<% List<CustomerModel> l = (List<CustomerModel>)request.getAttribute("data"); %>
<% if(l!=null){ for(CustomerModel temp : l) { %>
    <p><%=temp.getName()%></p>
<%}} %>
</body>
</html>