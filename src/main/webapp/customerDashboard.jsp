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
		<script src="https://cdn.tailwindcss.com"></script>

</head>
<body>
<%Long no=(Long)session.getAttribute("customer"); %>
    <div class="bg-blue-200 w-screen h-screen flex items-center justify-center">
        <div class="flex flex-col w-60 ">
		   <a class="w-full hover:bg-blue-700 mb-2 h-10 pt-2 bg-blue-500 text-white text-center rounded-xl" href="customerWithdraw.jsp">Withdraw Amount</a>
		   <a class="w-full hover:bg-blue-700 mb-2 h-10 pt-2 bg-blue-500 text-white text-center rounded-xl" href="customerDeposit.jsp">Deposit Amount</a>
		    <a class="w-full hover:bg-blue-700 mb-2 h-10 pt-2 bg-blue-500 text-white text-center rounded-xl" href="customerChangePassword.jsp">Change Password</a>
		    <a class="w-full hover:bg-blue-700 mb-2 h-10 pt-2 bg-blue-500 text-white text-center rounded-xl" href="closeAccount.jsp">Close Account</a>
		   <form class="w-full hover:bg-blue-700 mb-2 h-10 pt-2 bg-blue-500 text-white text-center rounded-xl" action="viewTransaction" method="post">
		    <input type="hidden" value="<%=no%>" name="no">
		     <input type="hidden" value="desc" name="order">
		    <button type="submit">View Transactions</button>
		   </form>
		   <button class="w-full hover:bg-blue-700 mb-2 h-10  bg-blue-500 text-white text-center rounded-xl" onclick="handleLogout()">Logout</button>
 </div>
    </div>
    
    <script>
     function handleLogout(){
    	 Swal.fire({
    		  title: "Are you sure to logout?",
    		  icon: "warning",
    		  showCancelButton: true,
    		  confirmButtonColor: "#3085d6",
    		  cancelButtonColor: "#d33",
    		  confirmButtonText: "Yes"
    		}).then((result) => {
    		  if (result.isConfirmed) {
    			  window.location.href="customerLogout.jsp";
    		    
    		  }
    		});
     }
    </script>
</body>
</html>    