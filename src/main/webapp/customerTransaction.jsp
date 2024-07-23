<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*,com.bankApplication.model.*" %>
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
</head>
<body>
<% List<TransactionModel> l =(List<TransactionModel>)request.getAttribute("data");%>
<%Long no=(Long)session.getAttribute("customer"); %>
<form action="viewTransaction" method="post">
    <input type="hidden" value="<%=no%>" name="no">
<select name="order" >
<p>orderBy</p>
  <option value="desc">Descending</option>
  <option value="asc">Ascending</option>
</select>
   
    <button type="submit">view t </button>
   </form>
   
<% if(l!=null){ for(TransactionModel temp : l) { %>
    <p><%=temp.getAno()%></p>
    <p><%=temp.getId()%></p>
<%}} %>
</body>
</html>