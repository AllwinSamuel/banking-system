package com.bankApplication.admin;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin/updateCustomer")
public class updateCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name =  request.getParameter("name");
		String address =  request.getParameter("address");
		String mobileno =  request.getParameter("mobileno");
		String mail =  request.getParameter("mail");
		String accountType =  request.getParameter("accountType");
		String dob =  request.getParameter("dob");
		String proof =  request.getParameter("proof");
		Long ano = Long.parseLong(request.getParameter("ano"));
		
		 try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","");
				String query = "update customer set name=?,address=?,mobileno=?,mail=?,accountType=?,dob=?,proof=? where ano=?";
		        PreparedStatement pst = con.prepareStatement(query);
		        pst.setString(1, name);
		        pst.setString(2,address );
		        pst.setString(3, mobileno);
		        pst.setString(4, mail);
		        pst.setString(5, accountType);
		        pst.setString(6, dob);
		        pst.setString(7, proof);
		        pst.setLong(8, ano);
		       
		        
		       int  rs = pst.executeUpdate();
		       RequestDispatcher d=null;
		       if(rs>0) {
		    	   System.out.println("succcessss");
		     	  d=request.getRequestDispatcher("dashboard.jsp");

		       }else {
		    	   System.out.println("fffaaaillleddd");

		       }
               d.forward(request, response);
		    }catch(Exception e) {
		    	System.out.println("errrrrot"+e.getMessage());
		    }
		    
	}

}
