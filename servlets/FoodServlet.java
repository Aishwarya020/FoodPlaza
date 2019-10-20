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

import com.foodplaza.dao.FoodDaoImpl;
import com.foodplaza.pojo.Food;

/**
 * Servlet implementation class foodServlet
 */
@WebServlet("/FoodServlet")
public class FoodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FoodServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		FoodDaoImpl fdao=new FoodDaoImpl();
		HttpSession session = request.getSession();
		String OP = request.getParameter("operation");
		
		if (OP != null && OP.equals("delete"))
				{
					int fid=Integer.parseInt(request.getParameter("foodId"));
					System.out.println(fid);
					boolean flag=fdao.deleteFood(fid);
					if(flag)
					{
						request.setAttribute("Success","Data Deleted Successfully");
					}
					else
					{
						request.setAttribute("Success","Data Not Deleted");
						
					}
					
					List<Food> flist = fdao.getAllFood();
					session.setAttribute("flist",flist);
					RequestDispatcher rd = request.getRequestDispatcher("FoodList.jsp");
					rd.forward(request,response);
					
				}
		
		else if(OP!=null && OP.equals("edit"))
		{
			int fid=Integer.parseInt(request.getParameter("foodId"));	
			System.out.println(fid);
			Food f = fdao.searchFoodById(fid);
			System.out.println(f);
			session.setAttribute("foodObj",f);
			RequestDispatcher rd = request.getRequestDispatcher("updatefood.jsp");
			System.out.println(rd);
			rd.forward(request,response);
			System.out.println(request);
			}
		
		else 
		{
		
		List<Food> flist = fdao.getAllFood();
		session.setAttribute("flist",flist);
		RequestDispatcher rd = request.getRequestDispatcher("FoodList.jsp");
		rd.forward(request,response);
		
		
		}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		FoodDaoImpl fdao= new FoodDaoImpl();
		HttpSession session = request.getSession();
		String Operations = request.getParameter("Operations");
		if(Operations !=null && Operations.equals("Add Food"))
		{
		String fname=request.getParameter("foodName");
		String ftype=request.getParameter("foodType");
		String fcat=request.getParameter("foodCategory");
		String fdesc=request.getParameter("foodDescription");
		Double fprice=Double.parseDouble(request.getParameter("foodPrice"));
		Food f = new Food(fname,ftype,fcat,fdesc,fprice);
		boolean flag= fdao.addFood(f);
		if(flag)
		{
			
			//response.sendRedirect("Success.html") ;
			List<Food> flist = fdao.getAllFood();
			session.setAttribute("flist",flist);
			RequestDispatcher rd = request.getRequestDispatcher("FoodList.jsp");
			rd.forward(request,response);
		}
		else
		{
			//response.sendRedirect("fail.html");
			List<Food> flist = fdao.getAllFood();
			session.setAttribute("flist",flist);
			RequestDispatcher rd = request.getRequestDispatcher("FoodList.jsp");
			rd.forward(request,response);
		}

		}
		
		else if(Operations !=null && Operations.equals("Update Food"))
		{
			int fid=Integer.parseInt(request.getParameter("foodId"));
			String fname=request.getParameter("foodName");
			String ftype=request.getParameter("foodType");
			String fcat=request.getParameter("foodCategory");
			String fdesc=request.getParameter("foodDescription");
			Double fprice=Double.parseDouble(request.getParameter("foodPrice"));
			Food f = new Food(fid,fname,ftype,fcat,fdesc,fprice);
			boolean flag= fdao.updateFood(f);
			if(flag)
			{
				
				//response.sendRedirect("Success.html") ;
				List<Food> flist = fdao.getAllFood();
				session.setAttribute("flist",flist);
				RequestDispatcher rd = request.getRequestDispatcher("FoodList.jsp");
				rd.forward(request,response);
			}
			else
			{
				//response.sendRedirect("fail.html");
				List<Food> flist = fdao.getAllFood();
				session.setAttribute("flist",flist);
				RequestDispatcher rd = request.getRequestDispatcher("FoodList.jsp");
				rd.forward(request,response);
			}
		}
		
		
		
		
		
	}

}
