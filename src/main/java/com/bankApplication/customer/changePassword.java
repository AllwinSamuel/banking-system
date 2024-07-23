package com.bankApplication.customer;

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

@WebServlet("/changePassword")
public class changePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long ano = Long.parseLong(request.getParameter("ano"));
		String opassword = request.getParameter("oldPassword");
		String npassword = request.getParameter("newPassword");

		RequestDispatcher d =null;
		
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
		
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","");
			String query = "select * from customer where ano=? and password=? ";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setLong(1,ano);
			pst.setString(2,opassword);
	        ResultSet rs = pst.executeQuery();
			
			if(rs.next()) {
				 System.out.println("succcccccwww");
				String query2 = "update customer set  password=? where ano=?";
				PreparedStatement pst2 = con.prepareStatement(query2);
				
				pst2.setString(1,npassword);
				pst2.setLong(2,ano);
				int rs1 = pst2.executeUpdate();
				if(rs1>0) System.out.println("succccccc");
				else 				System.out.println("failllllll");

			}else {
				System.out.println("failllll");
            }
			
		}
		catch(Exception e){
			 e.printStackTrace();
			}
	}

}
