package com.foodplaza.test;

import java.util.List;
import java.util.Iterator;
import java.util.Scanner;

import com.foodplaza.dao.CartDaoImpl;
import com.foodplaza.pojo.Cart;
import com.foodplaza.pojo.Customer;

public class CartTest {

	public static void main(String[] args) {
		CartDaoImpl adao=new CartDaoImpl();
		Cart cart=null;
		int cartid;
		int choice, foodid, foodqty;
		Scanner sc=new Scanner(System.in);
		boolean flag=false;
		Iterator i;
		List <Cart> ar ;
		String custemailid;
		System.out.println("1. Add to cart");
		System.out.println("2. update Cart");
		System.out.println("3. Delete Cart");
		System.out.println("4.Clear Cart");
		System.out.println("5. Show Cart");
		choice=sc.nextInt();
	
		
		switch(choice)
		{
		case 1:
			System.out.println("Enter Food ID");
			foodid=sc.nextInt();
			System.out.println("Enter Customer email ID");
			custemailid=sc.next();
			System.out.println("Enter Food Qty");
			foodqty=sc.nextInt();
			
			cart=new Cart();
			cart.setFoodId(foodid);
			cart.setFoodqty(foodqty);
			cart.setCustemailid(custemailid);
			flag=adao.addToCart(cart);
			if(flag)
        		System.out.println("Successfully added");
        	else
        		System.out.println("Sorry! Please try again");
        	break;
        	
		case 2:
			System.out.println("Enter Cart Id");
			cartid=sc.nextInt();
			System.out.println("Enter Food Qty");
			foodqty=sc.nextInt();
			
			
			flag=adao.updateCart( foodqty,  cartid);
			if(flag)
        		System.out.println("Successfully Update");
        	else
        		System.out.println("Sorry! Please try again");
        	break;
			
		case 3:
			System.out.println("Enter Cart ID");
			cartid=sc.nextInt();
			flag=adao.deleteCart(  cartid);
			if(flag)
        		System.out.println("Successfully Deleted");
        	else
        		System.out.println("Sorry! Please try again");
        	break;
        	
		case 4:
			System.out.println("Enter Customer Email ID");
			custemailid=sc.next();
			flag=adao.clearCart(  custemailid);
			if(flag)
        		System.out.println("Successfully Cleared");
        	else
        		System.out.println("Sorry! Please try again");
        	break;
        	
		case 5:
			System.out.println("Show all Cart");
			System.out.println("Enter Customer email ID");
			custemailid=sc.next();
			
			ar= adao.showCart(custemailid);
        	i=ar.iterator();
        	while(i.hasNext())
        	{
        		System.out.println(i.next());
        		
        	}
        	break;
			
			
			
			
		}
		

	}

}
