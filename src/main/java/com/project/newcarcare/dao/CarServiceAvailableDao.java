package com.project.newcarcare.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.newcarcare.dto.CarServiceAvailable;
import com.project.newcarcare.dto.Manager;
import com.project.newcarcare.repository.CarServiceAvailableRepository;

@Repository
public class CarServiceAvailableDao {
	@Autowired
	CarServiceAvailableRepository carServiceAvailableRepository;

	@Autowired
	ManagerDao managerDao;

	public CarServiceAvailable saveCarServiceAvailable(String id, CarServiceAvailable carServiceAvailable) {
		Manager manager = managerDao.getManager(id);
		if (manager != null) {
			carServiceAvailable.setManager(manager);
			return carServiceAvailableRepository.save(carServiceAvailable);
		}
		return null;

	}

	public CarServiceAvailable getCarServiveAvailable(int id) {
		Optional<CarServiceAvailable> opt = carServiceAvailableRepository.findById(id);
		if (opt.isEmpty()) {
			return null;
		}
		return opt.get();
	}

	public List<CarServiceAvailable> getAllCarServiceAvailable() {
		return carServiceAvailableRepository.findAll();
	}

	public boolean deleteCarServiceAvailable(int id) {
		CarServiceAvailable carServiceAvailable = getCarServiveAvailable(id);
		if (carServiceAvailable != null) {
			carServiceAvailableRepository.deleteById(id);
			return true;
		}
		return false;
	}

	public CarServiceAvailable updateCarServiceAvailable(int id, CarServiceAvailable carServiceAvailable) {
		CarServiceAvailable carServiceAvailable2 = getCarServiveAvailable(id);
		if (carServiceAvailable2 != null) {
			return carServiceAvailableRepository.save(carServiceAvailable);
		}
		return null;
	}
}
