package com.project.newcarcare.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.newcarcare.dto.Customer;
import com.project.newcarcare.repository.CustomerRepository;

@Repository
public class CustomerDao {
	@Autowired 
	CustomerRepository customerRepository;
	
	public Customer saveCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	
	public Customer getCustomerById(String id) {
		Optional<Customer> opt = customerRepository.findById(id);
		if(opt.isEmpty()) {
			return null;
		}
		return opt.get();
	}
	
	
	
	public List<Customer> getAllCustomer(){
		return  customerRepository.findAll();
	}
	
	
	public boolean deleteCustomer(String id) {
	  Customer customer =getCustomerById(id);
	  if(customer!=null) {
		 customerRepository.delete(customer);
		 return true;
	  }
	  return false;
	 
	}
	
	public Customer updateCustomer(String id,Customer customer) {
		  Customer customer2 =getCustomerById(id);
		  if(customer2!=null) {
			  return customerRepository.save(customer);
			
		  }
		  return null;
		
	}
	
	

}
