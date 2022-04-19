package com.project.newcarcare.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.newcarcare.dto.Branch;
import com.project.newcarcare.dto.Customer;
import com.project.newcarcare.repository.CustomerRepository;

@Repository
public class CustomerDao {
	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	BranchDao branchDao;

	public Customer saveCustomer(String id, Customer customer) {
		Branch branch = branchDao.getBranch(id);
		if (branch != null) {
			customer.setBranch(branch);
			return customerRepository.save(customer);

		}

		return null;
	}

	public Customer getCustomerById(String id) {
		Optional<Customer> opt = customerRepository.findById(id);
		if (opt.isEmpty()) {
			return null;
		}
		return opt.get();
	}

	public List<Customer> getAllCustomer(String id) {
		return customerRepository.getAllCustomer(id);
		
	}

	public boolean deleteCustomer(String id) {
		Customer customer = getCustomerById(id);
		if (customer != null) {
			customerRepository.deleteById(id);
			return true;
		}
		return false;

	}

	public Customer updateCustomer(String id, Customer customer) {
		Customer customer2 = getCustomerById(id);
		if (customer2 != null) {
			return customerRepository.save(customer);

		}
		return null;

	}

}
