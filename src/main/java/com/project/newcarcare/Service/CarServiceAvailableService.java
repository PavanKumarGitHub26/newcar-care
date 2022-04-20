package com.project.newcarcare.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.newcarcare.dao.CarServiceAvailableDao;
import com.project.newcarcare.dao.ManagerDao;
import com.project.newcarcare.dto.Branch;
import com.project.newcarcare.dto.CarServiceAvailable;

@Service
public class CarServiceAvailableService {
	@Autowired
	CarServiceAvailableDao carServiceAvailableDao;
	@Autowired
	ManagerDao managerDao;

	public CarServiceAvailable saveCarServiceAvailable(String id, CarServiceAvailable carServiceAvailable) {
		return carServiceAvailableDao.saveCarServiceAvailable(id, carServiceAvailable);
	}

	public CarServiceAvailable getCarServiceAvailable(int id) {
		CarServiceAvailable carServiceAvailable = carServiceAvailableDao.getCarServiveAvailable(id);
		if (carServiceAvailable == null) {
			return null;
		}
		return carServiceAvailable;
	}

	public List<CarServiceAvailable> getAllCarServiceAvailable() {
		return carServiceAvailableDao.getAllCarServiceAvailable();
	}

	public boolean removeCarServiceAvailable(int id) {
		CarServiceAvailable carServiceAvailable = carServiceAvailableDao.getCarServiveAvailable(id);
		if (carServiceAvailable != null) {
			carServiceAvailableDao.deleteCarServiceAvailable(id);
			return true;
		} else
			return false;
	}

	public CarServiceAvailable updateCarServiceAvailable(int id, CarServiceAvailable carServiceAvailable) {
		CarServiceAvailable carServiceAvailable2 = carServiceAvailableDao.getCarServiveAvailable(id);
		if (carServiceAvailable2 != null) {
			return carServiceAvailableDao.updateCarServiceAvailable(id, carServiceAvailable);
		}
		return null;
	}

}
