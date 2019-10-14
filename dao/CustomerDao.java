package com.foodplaza.dao;

import java.util.List;

import com.foodplaza.pojo.Customer;

public interface CustomerDao {
	boolean addCustomer(Customer customer);
	boolean updateCustomer(Customer customer);
	boolean deleteCustomer (int foodId);
	Customer searchCustomerById(int custid);
	Customer searchCustomerByEmailId(String custemailid);
	List <Customer> searchCustomerByName(String custname);
	
}
