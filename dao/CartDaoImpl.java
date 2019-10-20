package com.foodplaza.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.foodplaza.pojo.Cart;
import com.foodplaza.utility.DBUtility;
import java.sql.*;

public class CartDaoImpl implements CartDao {
	Connection con=DBUtility.connection();
	String sqlquery= null;
    PreparedStatement ps=null;
    ResultSet rs=null;
    
    List<Cart> cartlist=new ArrayList<Cart>();
    
    int row=0;
    
	@Override
	public boolean addToCart(Cart cart) {
		sqlquery = "insert into Cart20829 (foodid, custemailid, foodqty) values (?,?,?)";
		
		try {
			ps=con.prepareStatement(sqlquery);
			ps.setInt(1, cart.getFoodId());
			ps.setString(2, cart.getCustemailid());
			ps.setInt(3, cart.getFoodqty());
			
			row=ps.executeUpdate();
			
			if (row>0)
			{
				return true;
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean updateCart(int foodqty, int cartid) {
		sqlquery ="update Cart20829 set foodqty=? where cartid=?";
		try {
			ps=con.prepareStatement(sqlquery);
			ps.setInt(1, foodqty);
			ps.setInt(2, cartid);
			
         row=ps.executeUpdate();
			
			if (row>0)
			{
				return true;
			}
		}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		return false;
	}

	@Override
	public boolean deleteCart(int cartid) {
		sqlquery = "delete from Cart20829 where cartid=?";
		try {
			ps=con.prepareStatement(sqlquery);
			ps.setInt(1, cartid);
			
			row=ps.executeUpdate();
			if (row>0)
			{
				return true;
			}
		}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		return false;
	}

	@Override
	public boolean clearCart(String custemailid) {
		sqlquery = "delete from Cart20829 where custemailid=?";
		try {
			ps=con.prepareStatement(sqlquery);
			ps.setString(1, custemailid);
			
			row=ps.executeUpdate();
			if (row>0)
			{
				return true;
			}
		}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
		
		return false;
	}

	@Override
	public List<Cart> showCart(String custemailid) {
		sqlquery= "select c.cartid, c.foodid, f.foodname, f.foodprice, c.foodqty, c.custemailid from Cart20829 c inner join food f on(c.foodid=f.foodid) where custemailid=? ";
		try {
			ps=con.prepareStatement(sqlquery);
			ps.setString(1, custemailid);
			
			rs=ps.executeQuery();
			
			while(rs.next())
			{
				Cart cart=new Cart();
				cart.setCartId(rs.getInt(1));
				cart.setFoodId(rs.getInt(2));
				cart.setFoodName(rs.getString(3));
				cart.setFoodPrice(rs.getDouble(4));
				cart.setFoodqty(rs.getInt(5));
				cart.setCustemailid(rs.getString(6));
				
				cartlist.add(cart);
				
			}
			return cartlist;
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return null;
	}

}
