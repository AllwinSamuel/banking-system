package com.bankApplication.customer;

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

import model.TransactionModel;

@WebServlet("/viewTransaction")
public class viewTransactions extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long ano = Long.parseLong(request.getParameter("no"));
		String order = request.getParameter("order");
		System.out.print(ano);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","");
			String query = "select * from transaction where ano=? order by id desc limit 10";
			String query2 = "select * from transaction where ano=? order by id asc limit 11";

			if(order.equals("desc")) {
				PreparedStatement pst = con.prepareStatement(query);
				pst.setLong(1, ano);
				List<TransactionModel> list = new ArrayList<>();
				
				ResultSet rs = pst.executeQuery();
				
				if(rs.next()) {
					while(rs.next()) {
						TransactionModel cm = new TransactionModel();
						cm.setId(rs.getInt(1));
						cm.setAno(rs.getLong(2));
						cm.setDate(rs.getTimestamp(3));
						cm.setAmount(rs.getLong(4));
						cm.setType(rs.getString(5));
						list.add(cm);
						
					}
					System.out.print(list);

					RequestDispatcher d = request.getRequestDispatcher("customerTransaction.jsp");
					request.setAttribute("data",list);
					d.forward(request, response);
				}else {
					System.out.print("found");
				}
			}else {
				
				PreparedStatement pst = con.prepareStatement(query2);
				pst.setLong(1, ano);
				List<TransactionModel> list = new ArrayList<>();
				
				ResultSet rs = pst.executeQuery();
				
				if(rs.next()) {
					while(rs.next()) {
						TransactionModel cm = new TransactionModel();
						cm.setId(rs.getInt(1));
						cm.setAno(rs.getLong(2));
						cm.setDate(rs.getTimestamp(3));
						cm.setAmount(rs.getLong(4));
						cm.setType(rs.getString(5));
						list.add(cm);
						
					}
					
					RequestDispatcher d = request.getRequestDispatcher("customerTransaction.jsp");
					request.setAttribute("data",list);
					d.forward(request, response);
				}else {
					System.out.print("found");
				}
			}
			
		}catch(Exception e) {
			System.out.print("error in fetchin");
		}
	}

}
