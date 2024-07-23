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



@WebServlet("/display")
public class fetchCustomerdetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","");
			String query = "select * from customer";
			PreparedStatement pst = con.prepareStatement(query);
			List<CustomerModel> list = new ArrayList<>();
			
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()) {
				while(rs.next()) {
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
					list.add(cm);
					
				}
				
				RequestDispatcher d = request.getRequestDispatcher("admin/display.jsp");
				request.setAttribute("data",list);
				d.forward(request, response);
			}
			
		}catch(Exception e) {
			System.out.print("error in fetchin");
		}
		
	}


}
