package com.project.newcarcare.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.newcarcare.dto.Car;
import com.project.newcarcare.dto.Manager;
import com.project.newcarcare.repository.CarRepositery;

@Repository
public class CarDao {

	@Autowired
	private CarRepositery carRepositery;

	public Car saveCar(Car car) {
		return carRepositery.save(car);
	}

	public Car getCar(String no) {

		Optional<Car> optional = carRepositery.findById(no);
		if (optional.isEmpty()) {
			return null;
		}

		return optional.get();

	}

	public boolean removeCar(String no) {
		Car car =getCar(no);
		if(car!=null) {
			carRepositery.delete(car);
			return true;
		}
		return false;
	}
	
	
	public List<Car> getAllCars(){
		List<Car> cars=carRepositery.findAll();
		return cars;
	}
	
	
	public Car updateCar(String no,Car car) {
		Car car1=getCar(no);
		if(car1!=null)
		{
			return carRepositery.save(car);
		}
		return null;
	}
	
	
}
