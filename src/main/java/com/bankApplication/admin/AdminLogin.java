package com.bankApplication.admin;

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



@WebServlet("/login")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		RequestDispatcher d =null;
		
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
		
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","");
			String query = "select * from admin where name=? and password=? ";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1,name);
			pst.setString(2,password);
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()) {
				HttpSession session = request.getSession();
                session.setAttribute("adminId", rs.getInt("id"));
                d=request.getRequestDispatcher("admin/dashboard.jsp");
			}else {
                request.setAttribute("status", "failed");
                d=request.getRequestDispatcher("admin/login.jsp");
            }
			d.forward(request, response);
		}
		catch(Exception e){
			 e.printStackTrace();
			}
		
  }

}
