package com.sales.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sales.models.Customer;
import com.sales.repositories.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository custRepo;
	
	private List<Customer> customers;
	
	
	//return customer list from customer database
	
	public List<Customer> getCustomersDetails()  
	{
		customers = (List<Customer>)custRepo.findAll();
		
		return customers;
	}
	
	//save customer to database, returns instance of book
	
	public Customer addNewCustomer(Customer c)  
	{
		return custRepo.save(c);
	}
	
	//find customer by id, returns instance if found
	
	public Customer findCustomerById(Long id)  
	{
		return custRepo.findOne(id);
	}

}
