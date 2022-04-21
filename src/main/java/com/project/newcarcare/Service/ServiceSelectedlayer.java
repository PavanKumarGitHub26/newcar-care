package com.project.newcarcare.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.newcarcare.dao.ServiceSelectedDao;
import com.project.newcarcare.dto.ServiceSelected;

@Service
public class ServiceSelectedlayer {

	@Autowired
	ServiceSelectedDao serviceSelectedDao;
	
	public ServiceSelected saveserviceSelected(int crid, String bid, String cid,ServiceSelected serviceSelected) {
		return serviceSelectedDao.saveserviceSelected(crid, bid, cid, serviceSelected);
	}
}
