package com.project.newcarcare.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.newcarcare.dto.Car;
import com.project.newcarcare.dto.CarServiceAvailable;
import com.project.newcarcare.dto.Manager;
import com.project.newcarcare.repository.CarServiceAvailableRepository;
import com.project.newcarcare.repository.CarServiceRepository;

@Repository
public class CarServiceAvailableDao {
	@Autowired
	CarServiceAvailableRepository carServiceAvailableRepository;
	
    @Autowired
    ManagerDao managerDao;
	
	public CarServiceAvailable saveCarServiceAvailable(String id,CarServiceAvailable carServiceAvailable) {
		Manager manager = managerDao.getManager(id);
		if(manager!=null) {
			return carServiceAvailableRepository.save(carServiceAvailable);
		}
		return  null;
	}
	
	
	public CarServiceAvailable getCarServiceAvailableById(int id) {
		Optional<CarServiceAvailable> opt =carServiceAvailableRepository.findById(id);
		
		if(opt!=null) {
			return opt.get();
		}
		return null;
	}
	
	public boolean removeCarServiceAvailable(int id) {
		CarServiceAvailable carServiceAvailable  =getCarServiceAvailableById(id);
		if (carServiceAvailable != null) {
			carServiceAvailableRepository.deleteById(id);
			return true;
		}
		return false;
	}
	

	public CarServiceAvailable updateCarServiceAvailable(int id, CarServiceAvailable carServiceAvailable) {
		 CarServiceAvailable  carServiceAvailable1 = getCarServiceAvailableById(id);
		if (carServiceAvailable1 != null) {
			return carServiceAvailableRepository.save(carServiceAvailable1);
		}
		return null;
	}
	
	public List<CarServiceAvailable> getAllCarServiceAvailable(){
		return carServiceAvailableRepository.findAll();
	}

}
