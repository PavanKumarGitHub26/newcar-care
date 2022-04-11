package com.project.newcarcare.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.newcarcare.dto.CarService;
import com.project.newcarcare.repository.CarServiceRepository;

@Repository
public class CarServiceDao {
	@Autowired
	CarServiceRepository carServiceRepository;

	public CarService saveCarService(CarService carService) {
		return carServiceRepository.save(carService);
	}

	public CarService getCarServiceById(int id) {
		Optional<CarService> opt = carServiceRepository.findById(id);
		if (opt.isEmpty()) {
			return null;
		}
		return opt.get();
	}

	public List<CarService> getAllCarservice() {
		return carServiceRepository.findAll();
	}

	public boolean deleteCarService(int id) {
		CarService carService = getCarServiceById(id);
		if (carService != null) {
			carServiceRepository.delete(carService);
			return true;
		}
		return false;
	}
	
	public CarService updateCarService(int id,CarService carService) {
		CarService carService1=getCarServiceById(id);
		if(carService1!=null) {
		 return	carServiceRepository.save(carService);
			
		}
		return null;
			
		
	}

}
