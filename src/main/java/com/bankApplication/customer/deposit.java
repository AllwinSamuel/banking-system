package com.bankApplication.customer;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/deposit")
public class deposit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long ano = Long.parseLong(request.getParameter("ano"));
		Long balance = Long.parseLong(request.getParameter("balance"));
		String type = "deposit";
		 
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","");
			String query = "update customer set balance=balance+? where ano=? ";
			
			PreparedStatement pst = con.prepareStatement(query);
			pst.setLong(1,balance);
			pst.setLong(2,ano);
			int rs = pst.executeUpdate();
			if(rs>0) {
				
				String query2 = "insert into transaction(ano,amount,type) values (?,?,?)";
				PreparedStatement pst2 = con.prepareStatement(query2);
				 pst2.setLong(1,ano);
					pst2.setLong(2,balance);
					pst2.setString(3,type);
					int rs1 = pst2.executeUpdate();
					if(rs1>0)System.out.println("succ4");
			}
			
		}
	catch(Exception e) {
		
	}
	}

}
