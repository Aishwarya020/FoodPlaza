package com.foodPlaza.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import  com.foodplaza.dao.LoginDaoImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession() ;
		session.invalidate();
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("inside post");
		LoginDaoImpl daoImpl = new LoginDaoImpl();
		Boolean flag;		
		HttpSession session= request.getSession();
		PrintWriter out = response.getWriter();
		String action =request.getParameter("action");
		String type=request.getParameter("type");
		
		
		RequestDispatcher rd=null;
		
		if (action!=null && action.equalsIgnoreCase("login")) {
			String email=request.getParameter("customerEmailid");
			String pass =request.getParameter("password");
			
			
			System.out.println("inside Login");
			
			if(type!=null && type.equalsIgnoreCase("Customer")) {
				
				System.out.println("inside customer");
				
				
				flag=daoImpl.userLogin(email, pass);
				if(flag) {
					System.out.println("sucess");
					session.setAttribute("user",email);
					request.setAttribute("success", "<b style=\"color: red;\"/> "+"welcome "+email+" to Food Plaza");
					rd=request.getRequestDispatcher("index.jsp");
					rd.forward(request, response);
				}else {
					System.out.println("You have entered wrong input");
					out.println("<b style=\"color: red;\"/> You have entered wrong input");
					rd=request.getRequestDispatcher("login.jsp");
					rd.include(request, response);
				}
				}
			
			else if(type!=null && type.equalsIgnoreCase("Admin")) {
				System.out.println("inside admin");
				
				
				flag=daoImpl.adminLogin(email, pass);
				if(flag) {
					System.out.println("success");
					session.setAttribute("admin",email );
					request.setAttribute("success", "<b style=\"color: red;\"/> "+"welcome "+email+" to Food Plaza");
					rd=request.getRequestDispatcher("index.jsp");
					rd.forward(request, response);
				}
				
				
				else {
					System.out.println("You have entered wrong input");
					out.println("<b style=\"color: red;\"/> You have entered wrong input");
					rd=request.getRequestDispatcher("login.jsp");
					rd.include(request, response);
				}
				}
			
			
		}else if (action!=null && action.equalsIgnoreCase("changePass")) {
			System.out.println("inside change password");
			String email=(String)session.getAttribute("admin");
			String pass =request.getParameter("oldPassword");
			String newPassword=request.getParameter("newPassword");
			
			System.out.println(email+" "+pass+" "+newPassword);
			System.out.println("inside admin");
				
				
			//	String newPassword=request.getParameter("txtNewPassword");
			//	String cnfNewPassword=request.getParameter("cnfTxtNewPassword");
			//	if(email!=null && !email.isEmpty() && pass!=null && !pass.isEmpty() && newPassword!=null && !newPassword.isEmpty()&& cnfNewPassword!=null && !cnfNewPassword.isEmpty()) {
					flag=daoImpl.adminLogin(email, pass);
					if(flag) {
			//			if(newPassword==cnfNewPassword) {
						flag=daoImpl.adminChangePass(email, newPassword);
						if(flag) {
							System.out.println("sucess");
							session.invalidate();
							rd=request.getRequestDispatcher("login.jsp");
							System.out.println(rd);
							rd.forward(request, response);
						}
					
					else {
							System.out.println("You have entered wrong input");
							out.println("<b style=\"color: red;\"/> change password request failed");
							rd=request.getRequestDispatcher("ChangePassword.jsp");
							rd.include(request, response);
						}
						}
		
		else {
							System.out.println("You have new password and cofirm new password is different");
							out.println("<b style=\"color: red;\"/> You have entered wrong old Password");
							rd=request.getRequestDispatcher("ChangePassword.jsp");
							rd.include(request, response);
						}
		}
	}
}
					
				
			
		
	

