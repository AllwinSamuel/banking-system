package com.bankApplication.admin;

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

import model.CustomerModel;

@WebServlet("/admin/modify")
public class modifyCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 Long ano = Long.parseLong(request.getParameter("ano"));
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","");
			String query = "select * from customer where ano = ?";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setLong(1,ano);
			
			ResultSet rs = pst.executeQuery();
			
					if(rs.next()) {
						CustomerModel cm = new CustomerModel();
						cm.setId(rs.getInt(1));
						cm.setName(rs.getString(2));
						cm.setAddress(rs.getString(3));
						cm.setMobile(rs.getString(4));
						cm.setMail(rs.getString(5));
						cm.setAccountType(rs.getString(6));
						cm.setBalance(rs.getLong(7));
						cm.setDob(rs.getString(8));
						cm.setProof(rs.getString(9));
						cm.setAno(rs.getLong(10));
						
					
					
					RequestDispatcher d = request.getRequestDispatcher("modifyCustomer.jsp");
					request.setAttribute("data",cm);
					d.forward(request, response);
				
					}
			
		}catch(Exception e) {
			System.out.print("error in fetchin");
		}
		
	}

}
