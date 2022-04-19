package com.project.newcarcare.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.newcarcare.dao.ManagerDao;
import com.project.newcarcare.dto.Manager;

@Service
public class ManagerService {

	@Autowired
	ManagerDao managerDao;

	public Manager saveManager(Manager manager) {
		return managerDao.saveManager(manager);
	}

	public Manager getManager(String id) {
		Manager manager = managerDao.getManager(id);
		if (manager == null) {
			return null;
		}
		return manager;
	}
	public List<Manager> getAllManager(){
		return managerDao.getAllManagers();
	}
	
	
	public boolean removeManager(String id) {
		Manager manager=getManager(id);
		if(manager!=null) {
	  managerDao.removeManager(id);
		return true;
		}
		else
			return false;
	}
	
	public Manager updateManager(String id,Manager m1) {
		Manager manager=getManager(id);
		if(manager!=null)
		{
			return managerDao.updateManager(id, m1);
		}
		return null;
	}
	
	
	

}
