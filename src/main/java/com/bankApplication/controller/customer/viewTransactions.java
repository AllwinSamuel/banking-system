package com.bankApplication.controller.customer;

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

import com.bankApplication.dao.CustomerDao;
import com.bankApplication.model.TransactionModel;

@WebServlet("/viewTransaction")
public class viewTransactions extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long ano = Long.parseLong(request.getParameter("no"));
		String order = request.getParameter("order");
		
		 List<TransactionModel> list = CustomerDao.viewTransaction(ano, order);
         if(list!=null) {
        	 RequestDispatcher d = request.getRequestDispatcher("customerTransaction.jsp");
				request.setAttribute("data",list);
				d.forward(request, response);
         }
			
					
					
				
		
	}

}
