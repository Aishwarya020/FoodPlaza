package com.foodPlaza.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.foodplaza.dao.CustomerDaoImpl;

import com.foodplaza.pojo.Customer;

/**
 * Servlet implementation class CommonCustomerServlet
 */
@WebServlet("/CommonCustomerServlet")
public class CommonCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommonCustomerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		CustomerDaoImpl cdao=new CustomerDaoImpl();
		HttpSession session = request.getSession();
		String OP = request.getParameter("Operation");
		
		if (OP != null && OP.equals("delete"))
		{
			int cid=Integer.parseInt(request.getParameter("custid"));
			boolean flag=cdao.deleteCustomer(cid);
			if(flag)
			{
				request.setAttribute("Success","Data Deleted Successfully");
			}
			else
			{
				request.setAttribute("Success","Data Not Deleted");
				
			}
			
			
		}

else if(OP!=null && OP.equals("edit"))
{
	//int cid=Integer.parseInt(request.getParameter("custid"));	
	//System.out.println(cid);
	String email=(String)session.getAttribute("user");
	System.out.println(email);
	Customer c = cdao.searchCustomerByEmailId(email);
	System.out.println(c);
	session.setAttribute("CustObj",c);
	RequestDispatcher rd = request.getRequestDispatcher("updatecustomer.jsp");
	rd.forward(request,response);
	System.out.println("rd_edit"+rd);
	}

else 
{

List<Customer> clist = cdao.getAllCustomer();
session.setAttribute("clist",clist);
//System.out.println(clist);
RequestDispatcher rd = request.getRequestDispatcher("CustomerList.jsp");
rd.forward(request,response);
System.out.println("rd_edit2"+rd);


}



}
		
		
		


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		CustomerDaoImpl cdao= new CustomerDaoImpl();
		HttpSession session = request.getSession();
		String Operations = request.getParameter("Operations");
		
		if(Operations !=null && Operations.equals("Add Customer"))
		{
		String cname=request.getParameter("customerName");
		String cemailid=request.getParameter("customerEmailid");
		String cpas=request.getParameter("password");
		String caddr=request.getParameter("customerAddress");
		String cnum=request.getParameter("customerContactNo");
		Customer c = new Customer(cname,cemailid,cpas,caddr,cnum);
		boolean flag= cdao.addCustomer(c);
		if(flag)
		{
			
			//response.sendRedirect("Success.html") ;
			List<Customer> clist = cdao.getAllCustomer();
			session.setAttribute("clist",clist);
			System.out.println(clist);
			RequestDispatcher rd = request.getRequestDispatcher("CustomerList.jsp");
			rd.forward(request,response);
		}
		else
		{
			//response.sendRedirect("fail.html");
			List<Customer> clist = cdao.getAllCustomer();
			session.setAttribute("clist",clist);
			System.out.println(clist);
			RequestDispatcher rd = request.getRequestDispatcher("CustomerList.jsp");
			rd.forward(request,response);
		}

		}
		
		else if(Operations !=null && Operations.equals("Update Customer"))
		{
			
			int cid=Integer.parseInt(request.getParameter("customerId"));
			String cname=request.getParameter("customerName");
			String cemailid=request.getParameter("customerEmailid");
			String cpas=request.getParameter("password");
			String caddr=request.getParameter("customerAddress");
			String cnum=request.getParameter("customerContactNo");
			Customer c = new Customer(cid,cname,cemailid,cpas,caddr,cnum);
			boolean flag= cdao.updateCustomer(c);
			
			if(flag)
			{
				
				//response.sendRedirect("Success.html") ;
				List<Customer> clist = cdao.getAllCustomer();
				session.setAttribute("clist",clist);
				System.out.println(clist);
				RequestDispatcher rd = request.getRequestDispatcher("CustomerList.jsp");
				rd.forward(request,response);
			}
			else
			{
				//response.sendRedirect("fail.html");
				List<Customer> clist = cdao.getAllCustomer();
				session.setAttribute("clist",clist);
				System.out.println(clist);
				RequestDispatcher rd = request.getRequestDispatcher("CustomerList.jsp");
				rd.forward(request,response);
			}
		}
		
		
		
		
		
	}

		
		
		
	}


