<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <form action="customerLogin" method="post">
          <input 
		      type="number" 
		      placeholder="Account Number"
		      required
		      name="Ano"
		  >
		  <input 
		      type="password" 
		      placeholder="Password"
		      required
		      name="password"
		  >
		  <button type="submit">Login</button>
  </form>
</body>
</html>