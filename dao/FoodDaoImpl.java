package com.foodplaza.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.foodplaza.pojo.Food;
import com.foodplaza.utility.DBUtility;

public class FoodDaoImpl implements FoodDao {
	Connection con=DBUtility.connection();

	int row;
	
	@Override
	public boolean addFood(Food food) {
		try {
			
			PreparedStatement ps=con.prepareStatement("insert into food(foodname, foodtype, foodcategory, fooddescription, foodprice) values (?,?,?,?,?)");
	        ps.setString(1, food.getFoodName());
	        ps.setString(2, food.getFoodType());
	        ps.setString(3, food.getFoodCategory());
	        ps.setString(4, food.getFoodDescription());
	        ps.setDouble(5, food.getFoodPrice());
	        
	        row = ps.executeUpdate();
		} catch ( SQLException e) {
			
			e.printStackTrace();
		}
		
		if(row>0)
			return true;
		else
		return false;
	}

	@Override
	public boolean updateFood(Food food) {
		
      try {
			
			PreparedStatement ps=con.prepareStatement("Update food set foodname=?, foodtype=?, foodcategory=?, fooddescription=?, foodprice=? where foodid=?");
	        ps.setString(1, food.getFoodName());
	        ps.setString(2, food.getFoodType());
	        ps.setString(3, food.getFoodCategory());
	        ps.setString(4, food.getFoodDescription());
	        ps.setDouble(5, food.getFoodPrice());
	        ps.setInt(6, food.getFoodId());
	        
	        row = ps.executeUpdate();
		} catch ( SQLException e) {
			
			e.printStackTrace();
		}
		
		if(row>0)
			return true;
		else
		return false;
	}

	@Override
	public boolean deleteFood(int foodId) {
try {
			
			PreparedStatement ps=con.prepareStatement("Delete from food where foodid=?");
	        
	        ps.setInt(1, foodId);
	        
	        row = ps.executeUpdate();
		} catch ( SQLException e) {
			
			e.printStackTrace();
		}
		
		if(row>0)
			return true;
		else
		return false;
		
	}

	@Override
	public List<Food> getAllFood() {
		List<Food> list=new ArrayList<Food>();
		try
		{
			PreparedStatement ps=con.prepareStatement("Select * from food");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Food food=new Food(
						rs.getString("foodname"),
						rs.getString("foodtype"),
						rs.getString("foodcategory"),
						rs.getString("fooddescription"),
						rs.getDouble("foodprice")
						);
				food.setFoodId(rs.getInt("foodid"));
				list.add(food);
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
		
	}

	@Override
	public Food searchFoodById(int foodId) {
		Food food=null;
		try
		{
			PreparedStatement ps=con.prepareStatement("Select * from food where foodid=?");
			ps.setInt(1, foodId);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				 food=new Food(
						rs.getString("foodname"),
						rs.getString("foodtype"),
						rs.getString("foodcategory"),
						rs.getString("fooddescription"),
						rs.getDouble("foodprice")
						);
				food.setFoodId(rs.getInt("foodid"));
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return food;
	}

	@Override
	public List<Food> searchFoodByName(String foodName) {
		List<Food> list=new ArrayList<Food>();
		try
		{
			PreparedStatement ps=con.prepareStatement("Select * from food where foodname=?");
			 ps.setString(1, foodName);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Food food=new Food(rs.getInt("foodid"),
						rs.getString("foodname"),
						rs.getString("foodtype"),
						rs.getString("foodcategory"),
						rs.getString("fooddescription"),
						rs.getDouble("foodprice")
						);
				//food.setFoodId(rs.getInt("foodid"));
				list.add(food);
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Food> searchFoodByCategory(String foodCategory) {
		List<Food> list=new ArrayList<Food>();
		try
		{
			PreparedStatement ps=con.prepareStatement("Select * from food where foodCategory=?");
			 ps.setString(1, foodCategory);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Food food=new Food(
						rs.getString("foodname"),
						rs.getString("foodtype"),
						rs.getString("foodcategory"),
						rs.getString("fooddescription"),
						rs.getDouble("foodprice")
						);
				food.setFoodId(rs.getInt("foodid"));
				list.add(food);
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}

}
