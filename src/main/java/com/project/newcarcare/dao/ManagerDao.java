package com.project.newcarcare.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.newcarcare.dto.Manager;
import com.project.newcarcare.repository.ManagerRepository;


@Repository
public class ManagerDao {

	@Autowired
	private ManagerRepository managerRepository;

	public Manager saveManager(Manager manager) {
		return managerRepository.save(manager);
	}

	public Manager getManager(String id) {
		Optional<Manager> optional = managerRepository.findById(id);
		if (optional.isEmpty()) {
			return null;

		}

		Manager manager = optional.get();

		return manager;
	}
	
	
	public List<Manager> getAllManager(){
		return managerRepository.findAll();
	}
	
	public boolean removeManager(String id) {
		Manager manager=getManager(id);
		if(manager!=null) {
		managerRepository.deleteById(id);
		return true;
		}
		else
			return false;
	}
	
	public Manager updateManager(String id,Manager m1) {
		Manager manager=getManager(id);
		if(manager!=null)
		{
			return managerRepository.save(manager);
		}
		return null;
	}
}
