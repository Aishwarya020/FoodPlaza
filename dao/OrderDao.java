package com.foodplaza.dao;

import com.foodplaza.pojo.Order;

public interface OrderDao {
	
	
	Order placeOrder(String custemailid) ;
	boolean updateOrderStatus(int orderid);
	boolean cancelOrder (String custemailid , int orderid);	
	
	

}
