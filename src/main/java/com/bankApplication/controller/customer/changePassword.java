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

import com.bankApplication.dao.CustomerDao;

@WebServlet("/changePassword")
public class changePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long ano = Long.parseLong(request.getParameter("ano"));
		String oldPassword = request.getParameter("oldPassword");
		String newPassword = request.getParameter("newPassword");
        RequestDispatcher d =null;
 
		int rs = CustomerDao.changePassword(ano, oldPassword, newPassword);
			
				if(rs>0)System.out.println("succccccc");
				else System.out.println("failllllll");

			
			
	
	}

}
