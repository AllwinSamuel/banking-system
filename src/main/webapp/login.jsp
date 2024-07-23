<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11.12.2/dist/sweetalert2.all.min.js">
	</script>
<link href="https://cdn.jsdelivr.net/npm/sweetalert2@11.12.2/dist/sweetalert2.min.css" rel="stylesheet">
		<script src="https://cdn.tailwindcss.com"></script>

</head>
<body>
<input type="hidden" id="status" value="<%=request.getAttribute("status")%>" >

	<div class="h-screen flex items-center justify-center w-screen bg-blue-200">
	  <form class="h-60 w-60 flex flex-col items-center rounded-xl bg-white/20 shadow-2xl" method=post action=login>
	    <p class="text-xl font-bold text-blue-500 pt-6">ADMIN</p>
		 <input
		      class="w-[80%] placeholder:text-zinc-600 text-center mt-4 outline-none bg-transparent border-b-[3px] border-white" 
		      type="text" 
		      placeholder="Admin Name"
		      required
		      name="name"
		  >
		  <input 
		   class="w-[80%]  placeholder:text-zinc-600 text-center mt-4 outline-none bg-transparent border-b-[3px] border-white" 
		    
		      type="password" 
		      placeholder="Password"
		      required
		      name="password"
		  >
		  <button 
		  class="w-[80%] h-10  rounded-xl bg-blue-500 hover:bg-blue-600 text-white mt-6"
		  type="submit">Login</button>
		 
	</form> 
	</div>

	<script type="text/javascript">
	var status = document.getElementById("status").value;
	if(status == "failed"){
		Swal.fire({
			  icon: "error",
			  title: "Oops...",
			  text: "Wrong Credentials!",
			  
			});
	}
	
	</script>
</body>
</html>