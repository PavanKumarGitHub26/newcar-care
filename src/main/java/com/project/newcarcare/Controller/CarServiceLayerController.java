package com.project.newcarcare.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.newcarcare.Service.CarServiceLayer;
import com.project.newcarcare.dao.CustomerDao;
import com.project.newcarcare.dto.Car;
import com.project.newcarcare.dto.Customer;

@RestController

public class CarServiceLayerController {
	@Autowired
	CarServiceLayer carServiceLayer;
	
	@Autowired
	CustomerDao customerDao;
	
     @PostMapping("/car")
	public Car saveCar(@RequestParam String id,@RequestBody Car car) {
		Customer customer = customerDao.getCustomerById(id);
		{
			if (customer != null) {
				return carServiceLayer.saveCar(id, car);
			}
			return null;
		}

	}
     
     
     @GetMapping("/car")
 	public Car getCar(@RequestParam  String carNumber) {
		Car car= carServiceLayer.getCar(carNumber);
		if (car==null) {
			return null;
		}
		return car;
	}
     
     @GetMapping("/helloww")
 	public Car get() {
 		return new Car();
 	}
     
     

}
