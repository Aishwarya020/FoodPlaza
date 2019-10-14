package com.foodplaza.test;

import java.io.*;

import java.util.*;

import com.foodplaza.dao.FoodDaoImpl;
import com.foodplaza.pojo.Food;

public class FoodTest {

	public static void main(String[] args) throws IOException{
		FoodDaoImpl fdao=new FoodDaoImpl();
		int foodId;
		Food food=null;
		boolean b;
		Iterator i;
		ArrayList <Food> ar ;
		String foodName,foodType,foodCategory,foodDescription;
		double foodPrice;
		int choice;
		Scanner sc=new Scanner(System.in);
		
		InputStreamReader is=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(is);
		while(true) {
		System.out.println(" 1. Add Food \n 2. Update Food \n 3. Delete Food \n 4. Get All Food \n 5. Search Food By Id \n 6. Search Food By Food Name \n 7. Search Food By Category \n 8. Exit");
        choice=sc.nextInt();
        
        switch(choice)
        {
        case 1:
        	System.out.println("Add Food");
        	System.out.println("Enter Food Name : ");
        
        	System.out.println("Enter Food Type");
        	foodType=br.readLine();
        	System.out.println("Enter Food Category");
        	foodCategory=br.readLine();
        	System.out.println("Enter Food Description");
        	foodDescription=br.readLine();
        	System.out.println("Enter Food Price");
        	foodPrice=sc.nextDouble();
        	
        	food=new Food(foodName, foodType, foodCategory, foodDescription, foodPrice);
        	b=fdao.addFood(food);
        	fdao.addFood(food);
        	if(b)
        		System.out.println("Successfully added");
        	else
        		System.out.println("Sorry! Please try again");
        	break;
        	
        case 2:
        	System.out.println("Update Food");
        	System.out.println("Enter Food Id : ");
        	
        	System.out.println("Enter Food Name : ");
        	foodName=br.readLine();
        	System.out.println("Enter Food Type");
        	foodType=br.readLine();
        	System.out.println("Enter Food Category");
        	foodCategory=br.readLine();
        	System.out.println("Enter Food Description");
        	foodDescription=br.readLine();
        	System.out.println("Enter Food Price");
        	foodPrice=sc.nextDouble();
        	
        	food=new Food( foodName, foodType, foodCategory, foodDescription, foodPrice);
        	food.setFoodId(foodId);
        	
        	b=fdao.updateFood(food);
        	
        	if(b)
        		System.out.println("Successfully Updated");
        	else
        		System.out.println("Sorry! Please try again");
        	break;
        	
        case 3:
        	System.out.println("Delete Food");
        	
        	foodId=sc.nextInt();
        	b=fdao.deleteFood(foodId);
        	if(b)
        		System.out.println("Successfully Deleted");
        	else
        		System.out.println("Sorry! Please try again");
        	break;
        	
        case 4:
        	System.out.println("Get All Food");
        	ar= (ArrayList<Food>) fdao.getAllFood();
        	i=ar.iterator();
        	while(i.hasNext())
        	{
        		System.out.println(i.next());
        		
        	}
        	break;
        	
        case 5:
        	System.out.println("Get Food By Id");
        	System.out.println("Enter Food Id");
        	foodId=sc.nextInt();
        	ar=(ArrayList<Food>) fdao.searchFoodById(foodId);
        	i=ar.iterator();
        	while(i.hasNext())
        	{
        		System.out.println(i.next());
        		
        	}
        	break;
        	
        case 6:
        	
        	System.out.println("Get Food By Name");
        	System.out.println("Enter Food Name");
        	foodName=br.readLine();
        	ar=(ArrayList<Food>) fdao.searchFoodByName(foodName);
        	i=ar.iterator();
        	while(i.hasNext())
        	{
        		System.out.println(i.next());
        		
        	}
        	break;
        	
        case 7:
        	System.out.println("Get Food By Category");
        	System.out.println("Enter Food Category");
        	foodCategory=br.readLine();
        	ar=(ArrayList<Food>) fdao.searchFoodByCategory(foodCategory);
        	i=ar.iterator();
        	while(i.hasNext())
        	{
        		System.out.println(i.next());
        		
        	}
        	break;
        }}
	}

}
