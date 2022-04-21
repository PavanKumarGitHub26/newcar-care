package com.project.newcarcare.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.newcarcare.dto.Branch;
import com.project.newcarcare.dto.Car;
import com.project.newcarcare.dto.CarServiceAvailable;
import com.project.newcarcare.dto.Manager;
import com.project.newcarcare.dto.ServiceSelected;
import com.project.newcarcare.repository.ServiceSelectedRepository;

@Repository
public class ServiceSelectedDao {

	@Autowired
	CarServiceAvailableDao carServiceAvailableDao;
	
	@Autowired
	BranchDao branchDao;
	
	@Autowired
	CarDao carDao;
	
	@Autowired
	ServiceSelectedRepository selectedRepository;
	
	public ServiceSelected saveserviceSelected(int crid, String bid, String cid,ServiceSelected serviceSelected) {
		CarServiceAvailable carServiceAvailable=   carServiceAvailableDao.getCarServiveAvailable(crid);
		Branch branch=branchDao.getBranch(bid);
		Car car=carDao.getCar(cid);
		if(carServiceAvailable!=null && branch!=null && car!=null) {
			serviceSelected.setBranch(branch);
			serviceSelected.setCar(car);
			//serviceSelected.setCarServiceAvailables(null);
		}
		return null;
	}
	
	public ServiceSelected getServiceSelected(int id) {
		Optional<ServiceSelected> optional = selectedRepository.findById(id);
		if (optional.isEmpty()) {
			return null;
		}
		ServiceSelected serviceSelected = optional.get();
		return serviceSelected;
	}
	
	public List<ServiceSelected> getAllServiceSelected() {
		return selectedRepository.findAll();
	}
}
