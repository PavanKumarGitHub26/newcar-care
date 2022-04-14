package com.project.newcarcare.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.newcarcare.dto.Branch;
import com.project.newcarcare.dto.Car;

public interface CarRepositery extends JpaRepository<Car, String> {

	@Query("select c from Car c where c.customer.id=?1")
	public  List<Car> getAllCars(String id);

}
