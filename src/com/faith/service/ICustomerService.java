package com.faith.service;

import java.util.List;

import com.faith.model.Customer;

public interface ICustomerService {
	// Save Customer----------Reterive Select
	public void savecustomer(Customer customer);

	// List All Customers-----Create Insert
	public List<Customer> getCustomers();
	
    //update
	public Customer getCustomer(int theId);

	// delete customer
	public void deleteCustomer(int theId);
	// Search customer
 
}