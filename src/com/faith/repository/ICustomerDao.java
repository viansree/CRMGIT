package com.faith.repository;

import java.util.List;

import com.faith.model.Customer;

public interface ICustomerDao {
	//save Customer            create   insert
	public void saveCustomer(Customer customer);
	
	public Customer getCustomer(int theId);
		
		//list customer
		public List<Customer> getCustomers();
		
		
		
		public void deleteCustomer(int theId);

}
