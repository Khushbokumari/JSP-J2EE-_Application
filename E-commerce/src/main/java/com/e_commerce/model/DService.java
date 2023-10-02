package com.e_commerce.model;

import java.sql.ResultSet;

//Abstraction
public interface DService {
	public void connectDB();
	public boolean verifyLogin(String username,String password);
	public void signup(String name,String email,String password,String mobile);
	public boolean emailExits( String email);
	public boolean mobileExits(String mobile);
	public ResultSet getAllRegistrations();
	public void deleteByEmail(String email);
	public void updateRegistration(String email,String mobile);

}
