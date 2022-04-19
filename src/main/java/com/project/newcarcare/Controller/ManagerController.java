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

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class ManagerController {
	@Autowired
	ManagerService managerService;

	@ApiOperation(value = "save the manager details", produces = "application/json", consumes = "application/json")
	@ApiResponses({ @ApiResponse(code = 200, message = "manager saved"),
			@ApiResponse(code = 405, message = "bad request,not proper car data") })

	@PostMapping("/manager")
	public Manager saveManager(@RequestBody Manager manager) {
		return managerService.saveManager(manager);
	}

	@ApiOperation(value = "get the manager details", produces = "application/json", consumes = "application/json")
	@ApiResponses({ @ApiResponse(code = 200, message = "get manager"),
			@ApiResponse(code = 405, message = "bad request,not proper car data") })

	@GetMapping("/manager")
	public Manager getManagerById(@RequestParam String id) {
		return managerService.getManager(id);
	}

	@ApiOperation(value = "get all manager details", produces = "application/json", consumes = "application/json")
	@ApiResponses({ @ApiResponse(code = 200, message = "get all manager"),
			@ApiResponse(code = 405, message = "bad request,not proper car data") })

	@GetMapping("/allmanager")
	public List<Manager> getAllManager() {
		return managerService.getAllManager();
	}

	@ApiOperation(value = "delete the manager", produces = "application/json", consumes = "application/json")
	@ApiResponses({ @ApiResponse(code = 200, message = "manager deleted"),
			@ApiResponse(code = 405, message = "bad request,not proper car data") })

	@DeleteMapping("/manager")
	public void deleteManager(String id) {
		managerService.removeManager(id);
	}

	@ApiOperation(value = "update the manager details", produces = "application/json", consumes = "application/json")
	@ApiResponses({ @ApiResponse(code = 200, message = "manager updated"),
			@ApiResponse(code = 405, message = "bad request,not proper car data") })

	@PutMapping("/manager")
	public Manager updateManagerById(@RequestParam String id, @RequestBody Manager manager) {
		return managerService.updateManager(id, manager);
	}

	@ApiOperation(value = "to get the body ", produces = "application/json", consumes = "application/json")
	@ApiResponses({ @ApiResponse(code = 200, message = "body obtained"),
			@ApiResponse(code = 405, message = "bad request,not proper car data") })


	@GetMapping("/hii")
	public Manager get() {
		return new Manager();
	}

}
