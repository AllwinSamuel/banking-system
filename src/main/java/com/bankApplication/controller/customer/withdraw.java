package com.bankApplication.controller.customer;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bankApplication.dao.CustomerDao;

@WebServlet("/withdraw")
public class withdraw extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long ano = Long.parseLong(request.getParameter("ano"));
		Long balance = Long.parseLong(request.getParameter("balance"));
		
		int result = CustomerDao.withdraw(ano, balance);	
			
				   if(result>0)System.out.println("suc");
		
					else {
						System.out.println("cannot");
					}
				
			
	
	}

}
