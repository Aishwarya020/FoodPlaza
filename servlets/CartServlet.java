package com.foodPlaza.Servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.foodplaza.dao.CartDaoImpl;
import com.foodplaza.dao.OrderDaoImpl;
import com.foodplaza.pojo.Cart;
import com.foodplaza.pojo.Order;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		HttpSession session = request.getSession();
		String action=request.getParameter("operation");
		String username=(String)session.getAttribute("user");
		boolean flag ;
		CartDaoImpl cdao=new CartDaoImpl();
		
		if(action !=null && action.equals("addToCart"))
		{
			int fid=Integer.parseInt(request.getParameter("foodId"));
			Cart ct=new Cart();
			ct.setFoodId(fid);
			ct.setFoodqty(1);
			ct.setCustemailid(username);
			flag=cdao.addToCart(ct);
			if(flag)
			{
				request.setAttribute("Success","<center> <h1 style=color:red; align-text:center />Food added successfuly in cart </h1> </center>");
				
				RequestDispatcher rd=request.getRequestDispatcher("foodList.jsp");
				
				rd.forward(request,response);
				
			}
			
			else 
			{
                request.setAttribute("Failed","Food not added in cart");
				
				RequestDispatcher rd=request.getRequestDispatcher("FoodList.jsp");
				rd.forward(request,response);
			}
			}
		else if(action!=null && action.equals("delete"))
		{
			int cartId=Integer.parseInt(request.getParameter("cartId"));
			flag=cdao.deleteCart(cartId);
			if(flag)
			{
				request.setAttribute("success", "Food deleted successfully");
				List<Cart> cList=cdao.showCart(username);
				session.setAttribute("cList",cList );
				RequestDispatcher rd=request.getRequestDispatcher("CartList.jsp");
				rd.forward(request,response);

				
			}
			
		}
		else
		{
			List<Cart> cList=cdao.showCart(username);
			session.setAttribute("cList",cList );
			//System.out.println(cList);
			RequestDispatcher rd=request.getRequestDispatcher("CartList.jsp");
			//System.out.println(rd);
			rd.forward(request,response);
		}
			
		}
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		HttpSession session = request.getSession();
		OrderDaoImpl odao = new OrderDaoImpl();
		CartDaoImpl cdao = new CartDaoImpl();
		String price []=request.getParameterValues("price");
		String quantity []=request.getParameterValues("quantity");
		double totalbill=0.0;
		for(int i=0;i<price.length;i++)
		{
			totalbill+= Double.parseDouble(price[i])*Integer.parseInt(quantity[i]);
		}
LocalDate dt=LocalDate.now() ;

	String date = dt.toString();
	String email=(String)session.getAttribute("user");
	
	
	Order o = new Order();
	o.setCustemailid(email);
	o.setOrderdate(date);
	o.setTotalbill(totalbill);
	
	int orderId = odao.placeOrder(o);
	System.out.println(orderId);
	if(orderId > 0)
	{
		
		boolean flag=cdao.clearCart(email);
		request.setAttribute("order", "<center> <h1 style=color:red; align-text:center/> Your order is placed ."+"Order Id:"+"&nbsp"+orderId+"</br> </br>"+" Bill:"+totalbill+"</h1> </center>");
		
	    RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
	    rd.forward(request, response);
		
		
	}
	
		
	}

}
