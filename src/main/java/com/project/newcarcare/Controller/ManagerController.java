package com.project.newcarcare.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.newcarcare.Service.ManagerService;
import com.project.newcarcare.dto.Manager;

@RestController
public class ManagerController {
	@Autowired
	ManagerService managerService;
	

	@PostMapping("/manager")
	public Manager saveManager(@RequestBody  Manager manager) {
		return managerService.saveManager(manager);
	}
	
	@GetMapping("/manager")
	public Manager getManagerById(@RequestParam String id) {
		return managerService.getManager(id);
	}
	
	@GetMapping("/allmanager")
	public List<Manager> getAllManager(){
		return managerService.getAllManager();
	}
	
	
	@DeleteMapping("/manager")
	public void deleteHospital(String id) {
		managerService.removeManager(id);
	}
	
	@PutMapping("/manager")
	public Manager updateManagerById(@RequestParam String id, @RequestBody Manager manager) {
		return managerService.updateManager(id, manager);
	}
	

	@GetMapping("/hii")
	public Manager get() {
		return new Manager();
	}
	

}
