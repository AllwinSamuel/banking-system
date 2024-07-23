package com.bankApplication.controller.admin;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bankApplication.dao.AdminDao;
import com.bankApplication.model.CustomerModel;

@WebServlet("/modify")
public class modifyCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 Long ano = Long.parseLong(request.getParameter("ano"));
		
		 CustomerModel cm = AdminDao.modifyCustomer(ano);				
		 if(cm!=null) {
				RequestDispatcher d = request.getRequestDispatcher("modifyCustomer.jsp");
				request.setAttribute("data",cm);
				d.forward(request, response);
			
		 }			
					
				
		
		
	}

}
