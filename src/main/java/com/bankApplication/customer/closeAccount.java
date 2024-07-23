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
import javax.servlet.http.HttpSession;


@WebServlet("/closeAccount")
public class closeAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 Long ano = Long.parseLong(request.getParameter("ano"));
		 try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","");
				
				String query = "delete from transaction where ano = ?";
				PreparedStatement pst = con.prepareStatement(query);
				pst.setLong(1,ano);
				
				pst.executeUpdate();
				
		        String query2 = "delete from customer where ano = ?";
				PreparedStatement pst2 = con.prepareStatement(query2);
							pst2.setLong(1,ano);
							
							int rs1 = pst2.executeUpdate();
							
							if(rs1>0) {
								System.out.println("deleted");
							}
						
							HttpSession session = request.getSession();
			                session.setAttribute("customer", null);
			                session.setAttribute("customerBalance", null);
			}catch(Exception e) {
				System.out.print("error in fetchin");
			}
			
	}
}
