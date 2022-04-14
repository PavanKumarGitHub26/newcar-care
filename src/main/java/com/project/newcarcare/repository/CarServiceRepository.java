package com.project.newcarcare.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.newcarcare.dto.Car;
import com.project.newcarcare.dto.CarService;


public interface CarServiceRepository extends JpaRepository<CarService, Integer> {

	@Query("select cs from CarService cs where cs.branch.id= :bid and cs.car.carNumber= :cnum")
	public List<CarService> getAllCarService(String bid,String cnum);

}
