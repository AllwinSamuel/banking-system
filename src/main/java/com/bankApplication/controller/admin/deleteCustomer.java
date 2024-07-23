package com.bankApplication.controller.admin;

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

import com.bankApplication.dao.AdminDao;
import com.bankApplication.model.CustomerModel;


@WebServlet("/delete")
public class deleteCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 Long ano = Long.parseLong(request.getParameter("ano"));
		 
				
		int result = AdminDao.deleteCustomer(ano);					
							
				if(result>0) {
					response.sendRedirect("deleteIntro.jsp");
					System.out.print("deleted");
				}		
						
			
	}

}
