package com.e_commerce.model;

import java.sql.*;

public class DServiceImpl implements DService {
	private Connection con;
	private Statement stmnt;

	@Override
	public boolean verifyLogin(String username, String password) {
		try {
			ResultSet result=stmnt.executeQuery("Select* from ecom_login where email='"+username+"'and password='"+password+"' ");
			return result.next();
		}catch(Exception e) {e.printStackTrace();}
		
		// TODO Auto-generated method stub
		return false;
		
	}

	@Override
	public void connectDB() {
		
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce","root","1234");
			stmnt=con.createStatement();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void signup(String name, String email, String password, String mobile) {
		// TODO Auto-generated method stub
//		try {
//			stmnt.executeUpdate("insert into ecom_login values( '"+name+"','"+email+"','"+password+"','"+mobile+"')");
////			return result.next();
//		}catch(Exception e) {e.printStackTrace();}
//		
		// TODO Auto-generated method stub
		try {
		    String sql = "INSERT INTO ecom_login (name, email, password, mobile) VALUES (?, ?, ?, ?)";
		    PreparedStatement preparedStatement = con.prepareStatement(sql);
		    preparedStatement.setString(1, name);
		    preparedStatement.setString(2, email);
		    preparedStatement.setString(3, password);
		    preparedStatement.setString(4, mobile);
		    preparedStatement.executeUpdate();
		} catch (SQLException e) {
		    e.printStackTrace();
		}

		
	}

	@Override
	public boolean emailExits(String email) {
		try {
			ResultSet result=stmnt.executeQuery("Select* from ecom_login where email='"+email+"' ");
			return result.next();
		}catch(Exception e) {e.printStackTrace();}
		
		// TODO Auto-generated method stub
		return false;	}

	@Override
	public boolean mobileExits(String mobile) {
		try {
			ResultSet result=stmnt.executeQuery("Select* from ecom_login where mobile='"+mobile+"' ");
			return result.next();
		}catch(Exception e) {e.printStackTrace();}
		
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ResultSet getAllRegistrations() {
		try {
			ResultSet result=stmnt.executeQuery("Select* from ecom_login");
			return result;
		}catch(Exception e) {e.printStackTrace();}
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteByEmail(String email) {
		// TODO Auto-generated method stub
		try {
			stmnt.executeUpdate("delete from  ecom_login where email='"+email+"'");
//			return result.next();
		}catch(Exception e) {e.printStackTrace();}
		
		
	}

	@Override
	public void updateRegistration(String email, String mobile) {
		// TODO Auto-generated method stub
		try {
            String sql = "UPDATE ecom_login SET mobile = ? WHERE email = ?";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, mobile);
            preparedStatement.setString(2, email);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
//		try {
//			stmnt.executeUpdate("UPDATE ecom_login SET mobile='"+mobile+"' WHERE email='"+email+"'");
//////			return result.next();
//		}catch(Exception e) {e.printStackTrace();}
		
	}
	}
}

	
	
	


