package com.foodplaza.test;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.foodplaza.dao.OrderDaoImpl;
import com.foodplaza.pojo.Cart;
import com.foodplaza.pojo.Order;

public class OrderTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		OrderDaoImpl od = new OrderDaoImpl();
		Order order = null ;
		int orderid , choice;
	    String custemailid , orderdate ;
		double totalbill ;
		Scanner sc=new Scanner(System.in);
		boolean flag=false;
		Iterator i;
		List <Order> ord ;
		System.out.println("1. Place Order");
		System.out.println("2. Update Order");
		System.out.println("3. Cancel Order");
		
		choice=sc.nextInt();
		
		switch(choice)
		{
		
		case 1:
			
			System.out.println("Enter Customer email ID");
			custemailid=sc.next();
			
			order=od.placeOrder(custemailid);
			if(order!=null)
			{
				System.out.println("Order Placed");
				System.out.println("Order Details are");
				System.out.println(order);
			}
        		
        	else
        		System.out.println("Sorry! Please try again");
        	break;
        	
        	
		case 2 :
			
			System.out.println("Enter Email Id");
			custemailid=sc.next();
			System.out.println("Enter Order Id");
			orderid=sc.nextInt();
			
			flag=od.updateOrderStatus(orderid);
			
			if(flag)
        		System.out.println("Successfully Update");
        	else
        		System.out.println("Sorry! Please try again");
        	break;
			
        	
		case 3 :
			
			System.out.println("Enter Order ID");
			orderid=sc.nextInt();
			System.out.println("Enter Email Id");
			custemailid=sc.next();
			
			flag=od.cancelOrder(custemailid,orderid);
			if(flag)
        		System.out.println("Successfully Cancelled");
        	else
        		System.out.println("Sorry! Please try again");
        	break;
			
			
			
        	
		}
		
		

	}

}
