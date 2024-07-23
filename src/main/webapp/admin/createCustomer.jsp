<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method=post action="createCustomer">
	
	   <input 
	     type="text"
	     placeholder="Customer Name"
	     required
	     name="name"
	    >
	    
	    <input 
	     type="text"
	     placeholder="Address"
	     required
	     name="address"
	    >
	    
	    <input 
	     type="number"
	     placeholder="Mobile Number "
	     required
	     name="mobileno"
	    >
	    
	    <input 
	     type="mail"
	     placeholder="Email"
	     required
	     name="mail"
	    >
	    
	      <select name="accountType" required>
		    <option value="saving account">Saving account</option>
		    <option value="current account">Current account</option>
		  </select>
		  
		  <input 
	     type="number"
	     placeholder="Initial Balance"
	     min="1000"
	     required
	     name="balance"
	    >
	    
	    <input 
	     type="date"
	     required
	     name="dob"
	    >
	    <input 
	     type="text"
	     placeholder="Aadhar Number"
	     required
	     name="proof"
	    >
	    
	    <button type="submit">create</button>
	</form>
</body>
</html>