package com.project.newcarcare.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.project.newcarcare.dto.ServiceSelected;

@RestController
public class SelectedServiceController {

	@Autowired
	SelectedServiceController selectedServiceController;
	
	@PostMapping("/carServices/{crid}/branch/{bid}/car/{cid}")
	public ServiceSelected  saveServiceSelected(@PathVariable String crid,@PathVariable String bid,@PathVariable String cid,@RequestBody ServiceSelected serviceSelected ) {
		return selectedServiceController.saveServiceSelected(crid, bid, cid, serviceSelected);
	}
}
