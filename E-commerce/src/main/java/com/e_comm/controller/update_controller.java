package com.e_comm.controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.e_commerce.model.DServiceImpl;

/**
 * Servlet implementation class update_controller
 */
@WebServlet("/updates")
public class update_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public update_controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
//		
		request.setAttribute("email", email);
		request.setAttribute("mobile", mobile);
//		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/updatedata.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
//		String email = request.getParameter("email");
//	    String mobile = request.getParameter("mobile");
//
//	    DServiceImpl service = new DServiceImpl();
//	    service.connectDB();
//	    service.updateRegistration(email, mobile);
//	    
//	    ResultSet result=service.getAllRegistrations();
//		request.setAttribute("res", result);
//		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/views/show_signupdata.jsp");
//		rd.forward(request, response);
		 String email = request.getParameter("email");
		    String mobile = request.getParameter("mobile");

		    DServiceImpl service = new DServiceImpl();
		    service.connectDB();
		    service.updateRegistration(email, mobile);

		    // Assuming you don't write any content to the response here
		    // If you write any content to the response, it should be before the forward operation

		    ResultSet result = service.getAllRegistrations();
		    request.setAttribute("res", result);

		    // Forward to the appropriate view or JSP
		    RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/show_signupdata.jsp");
		    rd.forward(request, response);
//		   response.sendRedirect("show_signupdata.jsp");

	}

}
