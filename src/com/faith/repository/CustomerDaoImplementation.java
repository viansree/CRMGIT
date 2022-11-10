package com.faith.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.faith.model.Customer;
@Repository
public class CustomerDaoImplementation implements ICustomerDao{
	
	
	//Hibernate
	//need to inject the session Factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveCustomer(Customer customer) {
		//get thecurrent Hibernet session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//save the customer
		currentSession.saveOrUpdate(customer);
		
	}
	
    @Override
	public List<Customer> getCustomers(){
		
		//get the current Hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//create a query -- Sort by lastname
		Query<Customer> theQuery = currentSession.createQuery("from Customer order by lastName",Customer.class);
		//execute query and get result List
		 List<Customer> customers = theQuery.getResultList();
		 System.out.println(customers);
		//return the result 
		return customers;
	}

	@Override
	public Customer getCustomer(int theId) {
		//get the current Hibernate session

		Session currentSession = sessionFactory.getCurrentSession();
		//new retrieve/read from database using primary Key
		Customer thecustomer= currentSession.get(Customer.class, theId);
		
		return thecustomer;
	}
	@Override
	public void deleteCustomer(int theId) {
		
		//get the current hibernate session
				Session currentSession= sessionFactory.getCurrentSession();	
				
		//Delete object with Primary key
				Query theQuery =currentSession.createQuery("delete from Customer where id=:customerId");
				
				theQuery.setParameter("customerId", theId);
				
				//execute Query
				theQuery.executeUpdate();
				
	}


}
