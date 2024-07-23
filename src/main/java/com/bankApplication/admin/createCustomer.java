package com.bankApplication.admin;

import java.io.IOException;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin/createCustomer")
public class createCustomer extends HttpServlet{
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	String name =  request.getParameter("name");
	String address =  request.getParameter("address");
	String mobileno =  request.getParameter("mobileno");
	String mail =  request.getParameter("mail");
	String accountType =  request.getParameter("accountType");
	int balance =Integer.parseInt(request.getParameter("balance")) ;
	String dob =  request.getParameter("dob");
	String proof =  request.getParameter("proof");
	String password = generateNo();
	Long ano = 0L;
	try {
	  ano = generateANo();
	}catch(Exception e) {
		e.printStackTrace();
	}
       
     

   	

    try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","");
		String query = "insert into customer(name,address,mobileno,mail,accountType,balance,dob,proof,ano,password) values(?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement pst = con.prepareStatement(query);
        pst.setString(1, name);
        pst.setString(2,address );
        pst.setString(3, mobileno);
        pst.setString(4, mail);
        pst.setString(5, accountType);
        pst.setInt(6, balance);
        pst.setString(7, dob);
        pst.setString(8, proof);
        pst.setLong(9, generateANo());
        pst.setString(10, password);
        
       int  rs = pst.executeUpdate();
       RequestDispatcher d= null;
       if(rs>0) {
    	   System.out.println("succcessss");
    	  d=request.getRequestDispatcher("dashboard.jsp");
       }else {
    	   System.out.println("fffaaaillleddd");

       }
       d.forward(request, response);
    }catch(Exception e) {
    	System.out.println("errrrrot"+e.getMessage());
    }
    

}

private long generateANo() throws SQLException {
		
		Random random=new Random();
		long f=0;
		for(int i=0;i<15;i++) {
			int digit=random.nextInt(10);
			f=f*10+digit;
		}
		List<Long> prevAno=new ArrayList<>();
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","");
		PreparedStatement st=con.prepareStatement("select ano from customer");
		ResultSet rs=st.executeQuery();
		while(rs.next()) {
			prevAno.add(rs.getLong(1));
		}
		if(!prevAno.contains(f)) {
			return f;
		}
		else {
			return generateANo();
		}
		
	}

	private String generateNo() {
		  SecureRandom random = new SecureRandom();
	        StringBuilder password = new StringBuilder(10);

	        String digits = "0123456789";

	        for (int i = 0; i < 10; i++) {
	            int index = random.nextInt(digits.length());
	            password.append(digits.charAt(index));
	        }

	        return password.toString();
	}}
