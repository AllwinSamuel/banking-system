package com.bankApplication.controller.admin;

import java.io.IOException;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bankApplication.dao.AdminDao;
import com.bankApplication.model.CustomerModel;

@WebServlet("/createCustomer")
public class createCustomer extends HttpServlet{
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	String name =  request.getParameter("name");
	String address =  request.getParameter("address");
	String mobileno =  request.getParameter("mobileno");
	String mail =  request.getParameter("mail");
	String accountType =  request.getParameter("accountType");
	Long balance =Long.parseLong(request.getParameter("balance")) ;
	String dob =  request.getParameter("dob");
	String proof =  request.getParameter("proof");
	String password = AdminDao.generateNo();
	Long ano=0L;
	try {
		ano = AdminDao.generateANo();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	CustomerModel c = new CustomerModel();
	c.setName(name);
	c.setAddress(address);
	c.setMobile(mobileno);
	c.setMail(mail);
	c.setAccountType(accountType);
	c.setBalance(balance);
	c.setDob(dob);
	c.setProof(proof);
	c.setPassword(password);
	c.setAno(ano);
	
	
    int rs = AdminDao.createCustomer(c);

   	
      RequestDispatcher d= null;
       if(rs>0) {
    	   System.out.println("succcessss");
    	  d=request.getRequestDispatcher("dashboard.jsp");
       }else {
    	   System.out.println("fffaaaillleddd");

       }
       d.forward(request, response);
   

}



	}
