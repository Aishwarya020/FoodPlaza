package com.foodplaza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import com.foodplaza.pojo.Order;
import com.foodplaza.utility.DBUtility;

public class OrderDaoImpl implements OrderDao{
	
	String sqlquery=null;
	Connection con ;
	double totalbill ;
	PreparedStatement ps=null;
	ResultSet rs,rs1=null ;
	String orderdate ;
	

	
/*	public Order placeOrder(String custemailid) {
		Date date = new Date();
	try {
		con=DBUtility.connection ();
		sqlquery="Select sum(c.foodqty*f.foodprice) from Cart20829 c inner join food f on(c.foodid=f.foodid) where custemailid=?";
		ps=con.prepareStatement(sqlquery);
		ps.setString(1,custemailid);
		rs=ps.executeQuery();
		
		if(rs.next())
		{
			totalbill=rs.getDouble(1);
			orderdate=date.toString();
			sqlquery="insert into Order20829 (custemailid,orderdate,"+"totalbill)values(?,?,?)";
			ps=con.prepareStatement(sqlquery);
			ps.setString(1,custemailid);
			ps.setString(2,orderdate);
			ps.setDouble(3,totalbill);
			
			int row = ps.executeUpdate();
			if(row>0)
			{
				
			sqlquery="select * from Order20829 where custemailid=?"+"and orderdate=?" ;
			ps=con.prepareStatement(sqlquery);
			ps.setString(1,custemailid);
			ps.setString(2,orderdate);
			
			rs1=ps.executeQuery();
			
			if(rs1.next())
			{
				
				Order order = new Order(rs1.getInt("orderid"),
				rs1.getString("custemailid"),
				rs1.getString("orderdate"),
				rs1.getString("orderstatus"),
				rs1.getDouble("totalbill"));
				
				new CartDaoImpl().clearCart(custemailid);
				return order ;
				
			}
			}
			
			
		}
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
		
		return null;
	} */

	
	public boolean updateOrderStatus( int orderid) {
		// TODO Auto-generated method stub
		
		con=DBUtility.connection ();
		sqlquery ="update Order20829 set orderstatus='Processing' where orderid=?";
		try {
			ps=con.prepareStatement(sqlquery);
			ps.setInt(1, orderid);
			
			int row=ps.executeUpdate();
			
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
	public boolean cancelOrder(String custemailid, int orderid) {
		// TODO Auto-generated method stub
		
		con=DBUtility.connection ();
		sqlquery ="update Order20829 set orderstatus='Canceled' where orderid=? and custemailid=?";
		try {
			ps=con.prepareStatement(sqlquery);
			ps.setInt(1, orderid);
			ps.setString(2,custemailid);
			
			int row=ps.executeUpdate();
			
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
	public int placeOrder(Order o) {
		
		int orderId = 0;
		con=DBUtility.connection ();
		String str="insert into Order20829(custemailid,orderdate,totalbill) values (?,?,?)";
		try
		{
			ps=con.prepareStatement(str,Statement.RETURN_GENERATED_KEYS);
			ps.setString(1,o.getCustemailid());
			ps.setString(2,o.getOrderdate());
			ps.setDouble(3,o.getTotalbill());
			int row=ps.executeUpdate();
			rs=ps.getGeneratedKeys();
			while(rs.next())
			{
				orderId=rs.getInt(1);
				
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return orderId;

		
	}
}
	
	
	
	
	


