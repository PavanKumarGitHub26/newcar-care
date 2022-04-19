package com.project.newcarcare.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.newcarcare.dto.Car;
import com.project.newcarcare.dto.Customer;
import com.project.newcarcare.repository.CarRepositery;

@Repository
public class CarDao {

	@Autowired
	CustomerDao customerDao;

	@Autowired
	CarRepositery carRepositery;

	public Car saveCar(String id, Car car) {
		Customer customer = customerDao.getCustomerById(id);
		{
			if (customer != null) {
				car.setCustomer(customer);
				return carRepositery.save(car);
			}
			return null;
		}

	}

	public Car getCar(String carNumber) {
		Optional<Car> opt = carRepositery.findById(carNumber);
		if (opt.isEmpty()) {
			return null;
		}
		return opt.get();
	}

	public List<Car> getAllCar(String id) {
		return carRepositery.getAllCars(id);
	}

	public boolean deleteCarById(String id) {
		Car car = getCar(id);
		if (car != null) {
			carRepositery.deleteById(id);
			return true;
		}
		return false;
	}

	public Car updateCar(String carNumber, Car car) {
		Car car1 = getCar(carNumber);
		if (car1 != null) {
			carRepositery.save(car);
		}
		return null;
	}
}
