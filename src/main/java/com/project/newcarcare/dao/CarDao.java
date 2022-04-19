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
	private CarRepositery carRepositery;

	@Autowired
	private CustomerDao customerDao;

	public Car saveCar(String id, Car car) {
		Customer customer = customerDao.getCustomerById(id);
		if (customer != null) {
			car.setCustomer(customer);
			return carRepositery.save(car);

		}
		return null;
	}

	public Car getCar(String carNumber) {

		Optional<Car> optional = carRepositery.findById(carNumber);
		if (optional.isEmpty()) {
			return null;
		}

		return optional.get();

	}

	public boolean removeCar(String carNumber) {
		Car car = getCar(carNumber);
		if (car != null) {
			carRepositery.deleteById(carNumber);
			return true;
		}
		return false;
	}

	public List<Car> getAllCars(String id) {
		return carRepositery.getAllCars(id);
		
	}

	public Car updateCar(String carNumber, Car car) {
		Car car1 = getCar(carNumber);
		if (car1 != null) {
			return carRepositery.save(car);
		}
		return null;
	}

}
