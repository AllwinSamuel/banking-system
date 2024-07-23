package com.bankApplication.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;

import com.bankApplication.model.Customer;
import com.bankApplication.model.TransactionModel;

public class CustomerDao {
	 public static boolean customerLogin(Customer customer) {
	        boolean result = false;

	        try (Connection con = DBConnectionDao.getConnection()) {
	        	
	        	String query = "select * from customer where ano=? and password=? ";
				PreparedStatement pst = con.prepareStatement(query);
				pst.setLong(1,customer.getAno());
				pst.setString(2,customer.getPassword());
				ResultSet rs = pst.executeQuery();
				
	            if (rs.next()) {
	                result = true;
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return result;
	       }
	 
	 public static int changePassword(Long ano,String oldPassword ,String newpassword) {
           int result = 0;
	        try (Connection con = DBConnectionDao.getConnection()) {
	        	
	        	String query = "select * from customer where ano=? and password=? ";
				PreparedStatement pst = con.prepareStatement(query);
				pst.setLong(1,ano);
				pst.setString(2,oldPassword);
		        ResultSet rs = pst.executeQuery();
				
				if(rs.next()) {
					String query2 = "update customer set  password=? where ano=?";
					PreparedStatement pst2 = con.prepareStatement(query2);
					
					pst2.setString(1,newpassword);
					pst2.setLong(2,ano);
					int rs1 = pst2.executeUpdate();	
	            if(rs1>0) {
	            	result =1;
	            	}
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
     
     public static int deposit(Long ano ,Long amount) {
    	 int result = 0;
    	 String type = "deposit";
     try (Connection con = DBConnectionDao.getConnection()) {
    	 String query = "update customer set balance=balance+? where ano=? ";
			
			PreparedStatement pst = con.prepareStatement(query);
			pst.setLong(1,amount);
			pst.setLong(2,ano);
			int rs = pst.executeUpdate();
			if(rs>0) {
				
				String query2 = "insert into transaction(ano,amount,type) values (?,?,?)";
				PreparedStatement pst2 = con.prepareStatement(query2);
				 pst2.setLong(1,ano);
					pst2.setLong(2,amount);
					pst2.setString(3,type);
					int rs1 = pst2.executeUpdate();
					
					if(rs1>0) {
						result=1;
						}
					}
     
     } catch (Exception e) {
         e.printStackTrace();
     }

     return result;
     }
	 
     public static int withdraw(Long ano ,Long amount) {
    	 int result = 0;
    	 String type = "withdraw";
     try (Connection con = DBConnectionDao.getConnection()) {
		    	    String queryCheck = "select balance from customer where ano=?";
					PreparedStatement pst3 = con.prepareStatement(queryCheck);
					pst3.setLong(1,ano);
					ResultSet amt = pst3.executeQuery();
					
					if(amt.next()) {
							  Long currentBalnce = amt.getLong(1);
							  if(currentBalnce-amount>=0) {
								
								
										String query = "update customer set balance=balance-? where ano=? ";
										PreparedStatement pst = con.prepareStatement(query);
										pst.setLong(1,amount);
										pst.setLong(2,ano);
										int rs = pst.executeUpdate();	
										if(rs>0) {
											String query2 = "insert into transaction(ano,amount,type) values (?,?,?)";
											PreparedStatement pst2 = con.prepareStatement(query2);
											 pst2.setLong(1,ano);
												pst2.setLong(2,amount);
												pst2.setString(3,type);
												int rs1 = pst2.executeUpdate();
										
										if(rs1>0) {
											result=1;
											}
									   }
						      }
					}
	  }catch (Exception e) {
       e.printStackTrace();
     }

     return result;
}
			
     
     
     public static List<TransactionModel> viewTransaction(Long ano ,String order){
			List<TransactionModel> list = new ArrayList<>();
		     try (Connection con = DBConnectionDao.getConnection()) {
		      
						    	    String query = "select * from transaction where ano=? order by id desc limit 10";
									String query2 = "select * from transaction where ano=? order by id asc limit 11";
				
									if(order.equals("desc")) {
														PreparedStatement pst = con.prepareStatement(query);
														pst.setLong(1, ano);
														
														ResultSet rs = pst.executeQuery();
														
														
															while(rs.next()) {
																TransactionModel cm = new TransactionModel();
																cm.setId(rs.getInt(1));
																cm.setAno(rs.getLong(2));
																cm.setDate(rs.getTimestamp(3));
																cm.setAmount(rs.getLong(4));
																cm.setType(rs.getString(5));
																list.add(cm);
																}
									   }
									   else {
										
												   PreparedStatement pst = con.prepareStatement(query2);
												pst.setLong(1, ano);
												
												ResultSet rs = pst.executeQuery();
												
											
													while(rs.next()) {
														TransactionModel cm = new TransactionModel();
														cm.setId(rs.getInt(1));
														cm.setAno(rs.getLong(2));
														cm.setDate(rs.getTimestamp(3));
														cm.setAmount(rs.getLong(4));
														cm.setType(rs.getString(5));
														list.add(cm);
														
													
												}}
		     
						}catch (Exception e) {
		         e.printStackTrace();
		     }

		  return list;
		}
		
			
}
