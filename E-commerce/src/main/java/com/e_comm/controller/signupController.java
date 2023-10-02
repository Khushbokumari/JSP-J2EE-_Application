package com.e_comm.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.e_commerce.model.DServiceImpl;

/**
 * Servlet implementation class signup
 */
@WebServlet("/signup")
public class signupController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public signupController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		 RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/views/signup.jsp");
			rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String mobile = request.getParameter("mobile");

        System.out.println("name: " + name);
        System.out.println("email: " + email);
        System.out.println("password: " + password);
        System.out.println("mobile: " + mobile);
        
        
        DServiceImpl service=new DServiceImpl();
        service.connectDB();
        
        boolean statusOfEmail=service.emailExits(email);
        boolean mobileStatus=service.mobileExits(mobile);
        
        if(statusOfEmail) {
        	 request.setAttribute("msg", "Email already exits!!");
        	
        }
        else if(mobileStatus) {
        	request.setAttribute("msg", "Mobile no. already exits!!");
        
        }
        
        else {
        	
        	service.signup(name, email, password, mobile);
        	request.setAttribute("msg", "Record is saved!!");
        
        }
        
        RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/views/signup.jsp");
		rd.forward(request, response);
		
        
	}

}
