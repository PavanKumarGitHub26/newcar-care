package com.project.newcarcare.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.newcarcare.dao.CarDao;
import com.project.newcarcare.dao.CustomerDao;
import com.project.newcarcare.dto.Car;
import com.project.newcarcare.dto.Customer;

@Service
public class CarServiceLayer {
	@Autowired
	CarDao carDao;
	
	@Autowired
	CustomerDao customerDao;
	

	public Car saveCar(String id, Car car) {
		Customer customer = customerDao.getCustomerById(id);
		{
			if (customer != null) {
				return carDao.saveCar(id, car);
			}
			return null;
		}

	}
	
	public Car getCar(String carNumber) {
		Car car= carDao.getCar(carNumber);
		if (car==null) {
			return null;
		}
		return car;
	}
	
	public List<Car> getAllCar(String id) {
		return carDao.getAllCar(id);
	}
	
	public boolean deleteCarById(String id) {
		Car car = getCar(id);
		if (car != null) {
		carDao.deleteCarById(id);
			return true;
		}
		return false;
	}
	
	public Car updateCar(String carNumber, Car car) {
		Car car1 = getCar(carNumber);
		if (car1 != null) {
			carDao.updateCar(carNumber, car);
		}
		return null;
	}


}
