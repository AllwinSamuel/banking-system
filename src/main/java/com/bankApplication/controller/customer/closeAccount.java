package com.bankApplication.controller.customer;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bankApplication.dao.CustomerDao;
import com.bankApplication.model.Customer;


@WebServlet("/closeAccount")
public class closeAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 Long ano = Long.parseLong(request.getParameter("ano"));
		 String password = request.getParameter("password");
		 
		 Customer c = new Customer();
		 c.setAno(ano);
		 c.setPassword(password);
		 
		 boolean logged = CustomerDao.customerLogin(c);
		 
		if(logged) {
			 int result = CustomerDao.deleteCustomer(ano);
				if(result>0) {
					HttpSession session = request.getSession();
	                session.setAttribute("customer", null);
	                session.setAttribute("customerBalance", null);
	                response.sendRedirect("customerLogin.jsp");
				}	
		}		
							
		
			
	}
}
