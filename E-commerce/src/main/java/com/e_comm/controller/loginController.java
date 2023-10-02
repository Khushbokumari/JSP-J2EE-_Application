package com.e_comm.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.e_commerce.model.DServiceImpl;

@WebServlet("/vrfied")
public class loginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public loginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
//		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
//		String mobile=request.getParameter("mobile");
		DServiceImpl service=new DServiceImpl();
		service.connectDB();
		boolean status=service.verifyLogin(email, password);
		if(status) {
			RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/views/signup.jsp");
			rd.forward(request, response);
		}else {
			request.setAttribute("error", "Invalid username/password");
			RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
	}

}
