//package com.flipcart.model;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//public class DaServiceImpl implements DAService {
//	private Connection con;
//	private Statement stmnt;
//
//	@Override
//	public boolean vrfylogn(String username, String password) {
//		
//		// TODO Auto-generated method stub
//		try {
//            String query = "SELECT * FROM login WHERE email = ? AND password = ?";
//            
//            PreparedStatement pstmt = con.prepareStatement(query);
//            pstmt.setString(1, username);
//            pstmt.setString(2, password);
//
//            ResultSet result = pstmt.executeQuery();
//            
//            return result.next();
//        } catch (SQLException e) {
//            e.printStackTrace();
//            // Handle the SQL error appropriately
//        }
////		try {
////			ResultSet result=stmnt.executeQuery("Select * from login where email='"+username+"' and password='"+password+"'");
////			return result.next();
////			
////	    } catch (SQLException e) {
////	        e.printStackTrace(); // Print the SQL error
//////	   
////	    }
//		return false;
//	}
//
//	@Override
//	public void connectDB() {
//		
//		// TODO Auto-generated method stub
////		try {
////			Class.forName("com.mysql.cj.jdbc.Driver");
////			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce","root","1234");
////			stmnt=con.createStatement();
//////			
////		}catch(Exception e){
////			e.printStackTrace();
////			
////		}
//		try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce", "root", "1234");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//            System.err.println("MySQL JDBC driver not found.");
//        } catch (SQLException e) {
//            e.printStackTrace();
//            System.err.println("Failed to connect to the database.");
//        }
//    
//		
//	}
//
//
//public static void main(String[] args) {
//    // Create an instance of DaServiceImpl and connect to the database
//    DaServiceImpl dao = new DaServiceImpl();
//    dao.connectDB();
//    
//    // Test login verification
//    String testUsername = "test@example.com";
//    String testPassword = "testpassword";
//    
//    if (dao.vrfylogn(testUsername, testPassword)) {
//        System.out.println("Login successful.");
//    } else {
//        System.out.println("Login failed.");
//    }
//}
//}
package com.flipcart.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DaServiceImpl implements DAService {
    private Connection con;

    @Override
    public boolean vrfylogn(String username, String password) {
        try {
            // Ensure that 'connectDB' is called before using 'con'
            if (con == null || con.isClosed()) {
                System.err.println("Database connection is not established.");
                return false;
            }

            String query = "SELECT * FROM login WHERE email = ? AND password = ?";
            
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, username);
            pstmt.setString(2, password);

            ResultSet result = pstmt.executeQuery();
            
            return result.next();
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("SQL Error: " + e.getMessage());
        }
        return false;
    }

    @Override
    public void connectDB() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce", "root", "1234");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.err.println("MySQL JDBC driver not found.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Failed to connect to the database.");
        }
    }
}
