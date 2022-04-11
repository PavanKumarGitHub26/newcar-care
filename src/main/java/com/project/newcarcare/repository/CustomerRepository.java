package com.project.newcarcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.newcarcare.dto.Customer;

public interface CustomerRepository extends JpaRepository<Customer, String> {

}
