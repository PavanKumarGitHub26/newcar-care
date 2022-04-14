package com.project.newcarcare.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.newcarcare.dto.Branch;
import com.project.newcarcare.dto.Customer;

public interface CustomerRepository extends JpaRepository<Customer, String> {
	@Query("select c from Customer c where c.branch.id=?1")
	public List<Customer> getAllCustomer(String id) ;

}
