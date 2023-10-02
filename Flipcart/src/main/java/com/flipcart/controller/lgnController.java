//package com.flipcart.controller;
//
//import java.io.IOException;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import com.flipcart.model.DaServiceImpl;
//
//
///**
// * Servlet implementation class lgnController
// */
//@WebServlet("/vrfylogn")
//public class lgnController extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//       
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public lgnController() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
////		doGet(request, response);
//		String email=request.getParameter("email");
//		String password=request.getParameter("password");
//		DaServiceImpl service=new DaServiceImpl();
//		service.connectDB();
//		boolean status=service.vrfylogn(email, password);
//		System.out.println(status);
//	}
//
//}
package com.flipcart.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flipcart.model.DaServiceImpl;

@WebServlet("/vrfylogn")
public class lgnController extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    public lgnController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("username");
        String password = request.getParameter("password");
        
        // Implement your login verification logic here
        DaServiceImpl service = new DaServiceImpl();
        service.connectDB();
        boolean status = service.vrfylogn(email, password);
        
        // Assuming you want to redirect the user based on the login status
        if (status) {
        	System.out.println("welcome");
            // Successful login; redirect to a success page
//            response.sendRedirect("success.jsp"); // Replace with your success page
        } else {
            // Failed login; redirect to an error page or show an error message
        	System.out.println("error");
            //response.sendRedirect("error.jsp"); // Replace with your error page
        }
    }
}

