package com.bankApplication.controller.customer;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bankApplication.dao.CustomerDao;
import com.bankApplication.model.Customer;

@WebServlet("/customerLogin")
public class customerLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Long ano = Long.parseLong(request.getParameter("ano"));
		String password = request.getParameter("password");
		
		Customer customer = new Customer();
		customer.setAno(ano);
		customer.setPassword(password);
		
		RequestDispatcher d =null;
		
		boolean Logged = CustomerDao.customerLogin(customer);
			
			if(Logged) {
				HttpSession session = request.getSession();
                session.setAttribute("customer", ano);
                d=request.getRequestDispatcher("customerDashboard.jsp");
			}else {
                request.setAttribute("status", "failed");
                d=request.getRequestDispatcher("customerLogin.jsp");
            }
			d.forward(request, response);
		}
		
}
