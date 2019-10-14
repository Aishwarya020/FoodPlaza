package com.foodplaza.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import com.foodplaza.dao.CustomerDaoImpl;
import com.foodplaza.pojo.Customer;
import com.foodplaza.pojo.Food;


public class CustomerTest {

	public static void main(String[] args) throws IOException {
		CustomerDaoImpl cdao=new CustomerDaoImpl();
		
		int custid;
		Customer customer=null;
		boolean b;
		Iterator i;
		ArrayList <Customer> ar ;
		String custname, custemailid, password, address, contactno;
		
		int choice;
		Scanner sc=new Scanner(System.in);
		
		InputStreamReader is=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(is);
		while(true) {
		System.out.println(" 1. Add Customer \n 2. Update Customer \n 3. Delete Customer \n 4. Search Customer By ID \n 5. Search Customer By EmailID \n 6. Search Customer By Name \n 7. Get All Customer \n 8. Exit");
        choice=sc.nextInt();
		
        switch(choice)
        {
        case 1:
        	System.out.println("Add Customer");
        	System.out.println("Enter Customer Name : ");
        	custname=br.readLine();
        	System.out.println("Enter Customer EmailId :");
        	custemailid=br.readLine();
        	System.out.println("Enter Customer Password");
        	password=br.readLine();
        	System.out.println("Enter Customer Address ");
        	address=br.readLine();
        	System.out.println("Enter Customer ContactNo");
        	contactno=sc.next();
        	
        	customer=new Customer (custname, custemailid, password, address, contactno);
        	b=cdao.addCustomer(customer);
        	
        	if(b)
        		System.out.println("Successfully added");
        	else
        		System.out.println("Sorry! Please try again");
        	break;
        	
        case 2:
        	System.out.println("Update Customer");
        	System.out.println("Enter Customer Id : ");
        	custid=sc.nextInt();
        	System.out.println("Enter Customer Name : ");
        	custname=br.readLine();
        	System.out.println("Enter Customer EmailId :");
        	custemailid=br.readLine();
        	System.out.println("Enter Customer Password");
        	password=br.readLine();
        	System.out.println("Enter Customer Address ");
        	address=br.readLine();
        	System.out.println("Enter Customer ContactNo");
        	contactno=sc.next();
        	
        	customer=new Customer (custname, custemailid, password, address, contactno);
        	customer.setCustid(custid);
        	b=cdao.addCustomer(customer);
        	
        	if(b)
        		System.out.println("Successfully Updated");
        	else
        		System.out.println("Sorry! Please try again");
        	break;
        
        case 3:
        	System.out.println("Delete Customer");
        	System.out.println("Enter Customer Id");
        	custid=sc.nextInt();
        	b=cdao.addCustomer(customer);
        	if(b)
        		System.out.println("Successfully Deleted");
        	else
        		System.out.println("Sorry! Please try again");
        	break;
        	
        case 4:
        	System.out.println("Get Customer By Id");
        	System.out.println("Enter Customer Id");
        	custid=sc.nextInt();
        	customer = cdao.searchCustomerById(custid);
        	if(customer!=null) {        	
        	System.out.println(customer);
        	}
        	else {
        		System.out.println("Customer not found");
        	}
        	
        	break;
        	
        case 5:
        	System.out.println("Get Customer By EmailId");
        	System.out.println("Enter Customer EmailId");
        	custemailid=sc.next();
        	customer=  cdao.searchCustomerByEmailId(custemailid);
        	if(customer!=null) {        	
            	System.out.println(customer);
            }
        	else
        	{
            		System.out.println("Customer not found");
           	}
            	
        	break;
        	
        case 6:
        	System.out.println("Get Customer By Name");
        	System.out.println("Enter Customer Name");
        	custname=sc.next();
        	
        	ar=(ArrayList<Customer>) cdao.searchCustomerByName(custname);
        	i=ar.iterator();
        	while(i.hasNext())
        	{
        		System.out.println(i.next());
        		
        	}
        	
     
        	
        	break;
        	

        	
	}
		}}
}
