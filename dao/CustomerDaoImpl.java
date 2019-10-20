package com.foodplaza.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.foodplaza.pojo.Customer;
import com.foodplaza.pojo.Food;
import com.foodplaza.utility.DBUtility;

public class CustomerDaoImpl implements CustomerDao {
	Connection con=DBUtility.connection();
	
	int row;
	@Override
	public boolean addCustomer(Customer customer) {
     try {
			
			PreparedStatement ps=con.prepareStatement("insert into Customer20829(custname, custemailid, custpassword, custaddress, custnumber) values (?,?,?,?,?)");
	        ps.setString(1, customer.getCustname());
	        ps.setString(2, customer.getCustemailid());
	        ps.setString(3, customer.getPassword());
	        ps.setString(4, customer.getAddress());
	        ps.setString(5, customer.getContactno());
	        
	        row = ps.executeUpdate();
		} 
      catch ( SQLException e) 
        {
			
			e.printStackTrace();
		}
		
		if(row>0)
			return true;
		else
		return false;
	}

	@Override
	public boolean updateCustomer(Customer customer) {
      try {
			
			PreparedStatement ps=con.prepareStatement("Update Customer20829 set custname=?, custemailid=?, custpassword=?, custaddress=?, custnumber=? where custid=?");
	        ps.setString(1, customer.getCustname());
	        ps.setString(2, customer.getCustemailid());
	        ps.setString(3, customer.getPassword());
	        ps.setString(4, customer.getAddress());
	        ps.setString(5, customer.getContactno());
	        ps.setInt(6, customer.getCustid());
	        
	        row = ps.executeUpdate();
		} 
      catch ( SQLException e) 
        {
			
			e.printStackTrace();
		}
		
		if(row>0)
			return true;
		else
		return false;
	}

	@Override
	public boolean deleteCustomer(int custid) {
  try {
			
			PreparedStatement ps=con.prepareStatement("Delete from Customer20829 where custid=?");
	        
	        ps.setInt(1, custid);
	        
	        row = ps.executeUpdate();
		} catch ( SQLException e) {
			
			e.printStackTrace();
		}
		
		if(row>0) {
			return true;}
		else
		return false;
	}

	@Override
	public Customer searchCustomerById(int custid) {
		Customer customer=null;
      try {
			
			PreparedStatement ps=con.prepareStatement("Select * from Customer20829 where custid=?");
			ps.setInt(1, custid);
			ResultSet rs=ps.executeQuery();
		    
			if (rs.next())
			{
			 customer=new Customer(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
				customer.setCustid(rs.getInt(1));
			}
       }
        catch(Exception e)
         {
	             e.printStackTrace();
         }
	        
		return customer;
	}
		

	@Override
	public List<Customer> searchCustomerByName(String custname) {
		List<Customer> list=new ArrayList<Customer>();
		try
		{
			PreparedStatement ps=con.prepareStatement("Select * from Customer20829 where custname=?");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Customer customer=new Customer(
						rs.getString("custname"),
						rs.getString("custemailid"),
						rs.getString("custpassword"),
						rs.getString("custaddress"),
						rs.getString("custnumber")
						);
				customer.setCustid(rs.getInt("custid"));
				list.add(customer);
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
				
		return list;
	}

	@Override
	public List<Customer> getAllCustomer() {
		List<Customer> list=new ArrayList<Customer>();
		try
		{
			PreparedStatement ps=con.prepareStatement("Select * from Customer20829");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Customer customer=new Customer(
						rs.getString("custname"),
						rs.getString("custemailid"),
						rs.getString("custpassword"),
						rs.getString("custaddress"),
						rs.getString("custnumber")
						);
				customer.setCustid(rs.getInt("custid"));
				list.add(customer);
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}

}
