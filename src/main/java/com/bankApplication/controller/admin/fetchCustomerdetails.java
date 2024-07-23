package com.bankApplication.controller.admin;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bankApplication.dao.AdminDao;
import com.bankApplication.model.CustomerModel;



@WebServlet("/display")
public class fetchCustomerdetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
			List<CustomerModel> list = AdminDao.fetchCustomer();
			if(list!=null) {
			
				RequestDispatcher d = request.getRequestDispatcher("display.jsp");
				request.setAttribute("data",list);
				d.forward(request, response);
				
			}
			
		
	}


}
