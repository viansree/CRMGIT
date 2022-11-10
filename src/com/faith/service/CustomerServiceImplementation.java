package com.faith.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.faith.model.Customer;
import com.faith.repository.ICustomerDao;

@Service
public class CustomerServiceImplementation implements ICustomerService {

	// need to inject Customer DAO
	@Autowired
	private ICustomerDao customerDAO;
    @Override
    @Transactional
	public void savecustomer(Customer customer) {
    	customerDAO.saveCustomer(customer);

	}
    
    @Override
	@Transactional
	public List<Customer> getCustomers(){
		// TODO Auto-generated method stub
		return customerDAO.getCustomers();
	}

	@Override
	@Transactional
	public Customer getCustomer(int theId) {
		return customerDAO.getCustomer(theId);
		
	}

	@Override
	@Transactional
	public void deleteCustomer(int theId) {
		customerDAO.deleteCustomer(theId);
		
	}

}