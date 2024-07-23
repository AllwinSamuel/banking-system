package com.bankApplication.controller.admin;

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

import com.bankApplication.dao.AdminDao;
import com.bankApplication.model.CustomerModel;

@WebServlet("/updateCustomer")
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
		
		
		CustomerModel c = new CustomerModel();
		c.setName(name);
		c.setAddress(address);
		c.setMobile(mobileno);
		c.setMail(mail);
		c.setAccountType(accountType);
		c.setDob(dob);
		c.setProof(proof);
		c.setAno(ano);
		 
		RequestDispatcher d = null;
		int result = AdminDao.updateCustomer(c);
		       if(result>0) {
		    	   System.out.println("succcessss");
		     	  d=request.getRequestDispatcher("dashboard.jsp");

		       }else {
		    	   System.out.println("fffaaaillleddd");

		       }
               d.forward(request, response);
		    
		    
	}

}
