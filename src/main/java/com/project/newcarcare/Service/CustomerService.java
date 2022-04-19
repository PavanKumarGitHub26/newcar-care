package com.project.newcarcare.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.newcarcare.dao.BranchDao;
import com.project.newcarcare.dao.CustomerDao;
import com.project.newcarcare.dto.Customer;

@Service
public class CustomerService {

	@Autowired
	CustomerDao customerDao;
	@Autowired
	BranchDao branchDao;

	public Customer savecustomer(String id, Customer customer) {
		return customerDao.saveCustomer(id, customer);
	}

	public Customer getcustomer(String id) {
		Customer customer = customerDao.getCustomerById(id);
		if (customer == null) {
			return null;
		}
		return customer;
	}

	public List<Customer> getAllcustomer(String id) {
		return customerDao.getAllCustomer(id);
	}

	public boolean removecustomer(String id) {
		Customer customer = getcustomer(id);
		if (customer != null) {
			customerDao.deleteCustomer(id);
			return true;
		} else
			return false;
	}

	public Customer updatecustomer(String id, Customer customer) {
		Customer customer2 = getcustomer(id);
		if (customer2 != null) {
			return customerDao.updateCustomer(id, customer2);
		}
		return null;
	}

}
