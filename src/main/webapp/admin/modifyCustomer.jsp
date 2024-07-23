<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*,model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <%CustomerModel cm = (CustomerModel)request.getAttribute("data"); %>
 
 <form method=post action="updateCustomer">
	   
	   <input 
	     value="<%=cm.getAno()%>"
	     name="ano"
	    >
	    
	   <input 
	     type="text"
	     placeholder="Customer Name"
	     value="<%=cm.getName()%>"
	     required
	     name="name"
	    >
	    
	    <input 
	     type="text"
	     placeholder="Address"
	     value="<%=cm.getAddress()%>"
	     required
	     name="address"
	    >
	    
	    <input 
	     type="number"
	     placeholder="Mobile Number "
	     value="<%=cm.getMobile()%>"
	     required
	     name="mobileno"
	    >
	    
	    <input 
	     type="mail"
	     placeholder="Email"
	     value="<%=cm.getMail()%>"
	     required
	     name="mail"
	    >
	    
	      <select name="accountType" value="<%=cm.getAccountType()%>" required>
		    <option value="saving account">Saving account</option>
		    <option value="current account">Current account</option>
		  </select>
		  

	    
	    <input 
	     type="date"
	     required
	     name="dob"
	     value="<%=cm.getDob()%>"
	    >
	    <input 
	     type="text"
	     placeholder="Aadhar Number"
	     value="<%=cm.getProof()%>"
	     required
	     name="proof"
	    >
	    
	    <button type="submit">Update</button>
	</form>
</body>
</html>