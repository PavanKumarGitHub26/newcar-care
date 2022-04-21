package com.project.newcarcare.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.newcarcare.dto.Car;
import com.project.newcarcare.dto.ServiceSelected;


public interface ServiceSelectedRepository extends JpaRepository<ServiceSelected, Integer> {

	@Query("select cs from ServiceSelected cs where cs.branch.id= :bid and cs.car.carNumber= :cnum")
	public List<ServiceSelected> getAllCarService(String bid,String cnum);

}
