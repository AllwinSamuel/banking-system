package com.bankApplication.dao;

import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.bankApplication.model.Admin;
import com.bankApplication.model.CustomerModel;


public class AdminDao {

   
     public static boolean adminLogin(Admin admin) {
        boolean result = false;

        try (Connection con = DBConnectionDao.getConnection()) {
        	
        	String query = "SELECT * FROM admin WHERE name = ? AND password = ?";
        	PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, admin.getUsername());
            pst.setString(2, admin.getPassword());
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                result = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
       }
     
     public static String generateNo() {
		  SecureRandom random = new SecureRandom();
	        StringBuilder password = new StringBuilder(10);

	        String digits = "0123456789";

	        for (int i = 0; i < 10; i++) {
	            int index = random.nextInt(digits.length());
	            password.append(digits.charAt(index));
	        }

	        return password.toString();
	}
     
     public static long generateANo() throws SQLException {
 		
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
     
     public static int createCustomer(CustomerModel c) {
    	 int result = 0;
    	   try (Connection con = DBConnectionDao.getConnection()) {
           	
    		   String query = "insert into customer(name,address,mobileno,mail,accountType,balance,dob,proof,ano,password) values(?,?,?,?,?,?,?,?,?,?)";
    	        PreparedStatement pst = con.prepareStatement(query);
    	        pst.setString(1, c.getName());
    	        pst.setString(2,c.getAddress() );
    	        pst.setString(3, c.getMobile());
    	        pst.setString(4, c.getMail());
    	        pst.setString(5, c.getAccountType());
    	        pst.setLong(6, c.getBalance());
    	        pst.setString(7, c.getDob());
    	        pst.setString(8, c.getProof());
    	        pst.setLong(9,c.getAno());
    	        pst.setString(10, c.getPassword());
    	        
    	       int  rs = pst.executeUpdate();

               if (rs>0) {
                   result = 1;
               }

           } catch (Exception e) {
               e.printStackTrace();
           }

           return result;
     }
     
     public static int deleteCustomer(Long ano) {
    	 int result = 0;
    	   try (Connection con = DBConnectionDao.getConnection()) {
           	
    		   String query = "delete from transaction where ano = ?";
				PreparedStatement pst = con.prepareStatement(query);
				pst.setLong(1,ano);
				
				pst.executeUpdate();
				
		        String query2 = "delete from customer where ano = ?";
				PreparedStatement pst2 = con.prepareStatement(query2);
				pst2.setLong(1,ano);
    	        
                int rs = pst2.executeUpdate();
							
               if (rs>0) {
                   result = 1;
               }

           } catch (Exception e) {
               e.printStackTrace();
           }

           return result;
     }
     
     public static List<CustomerModel> fetchCustomer(){
			List<CustomerModel> list = new ArrayList<>();
  
			try(Connection con = DBConnectionDao.getConnection()){
				String query = "select * from customer";
				PreparedStatement pst = con.prepareStatement(query);
				ResultSet rs = pst.executeQuery();
				
				
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
			}catch(Exception e) {
				e.printStackTrace();
			}
			
    	 return list;
     }
     public static CustomerModel modifyCustomer(Long ano) {
			CustomerModel cm = new CustomerModel();
			try(Connection con = DBConnectionDao.getConnection()){
				String query = "select * from customer where ano = ?";
				PreparedStatement pst = con.prepareStatement(query);
				pst.setLong(1,ano);
				ResultSet rs = pst.executeQuery();
				if(rs.next()) {
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
					}
			}catch(Exception e) {
				e.printStackTrace();
			}
			
          return cm;
     }
     
     public static int updateCustomer(CustomerModel c) {
    	 int result =0;
			try(Connection con = DBConnectionDao.getConnection()){
				String query = "update customer set name=?,address=?,mobileno=?,mail=?,accountType=?,dob=?,proof=? where ano=?";
		        PreparedStatement pst = con.prepareStatement(query);
		        pst.setString(1, c.getName());
		        pst.setString(2,c.getAddress() );
		        pst.setString(3, c.getMobile());
		        pst.setString(4, c.getMail());
		        pst.setString(5, c.getAccountType());
		        pst.setString(6, c.getDob());
		        pst.setString(7, c.getProof());
		        pst.setLong(8, c.getAno());
		       
		        int  rs = pst.executeUpdate();
		        if (rs>0) {
	                   result = 1;
	               }
			}catch(Exception e) {
				e.printStackTrace();
			}
    	 
    	 return result;
     }
}