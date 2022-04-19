package com.project.newcarcare.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.newcarcare.Service.CustomerService;
import com.project.newcarcare.dto.Customer;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class CustomerController {

	@Autowired
	CustomerService customerService;
	
	

	@ApiOperation(value = "save the customer details", produces = "application/json", consumes = "application/json")
	@ApiResponses({ @ApiResponse(code = 200, message = "customer saved"),
			@ApiResponse(code = 405, message = "bad request,not proper car data") })

	@PostMapping("/customer")
	public Customer savecustomer(@RequestParam String id, @RequestBody Customer customer) {
		return customerService.savecustomer(id, customer);
	}

	@ApiOperation(value = "get the customer details", produces = "application/json", consumes = "application/json")
	@ApiResponses({ @ApiResponse(code = 200, message = "get customer"),
			@ApiResponse(code = 405, message = "bad request,not proper car data") })

	@GetMapping("/customer")
	public Customer getcustomerById(@RequestParam String id) {
		return customerService.getcustomer(id);
	}

	@ApiOperation(value = "get all customer details", produces = "application/json", consumes = "application/json")
	@ApiResponses({ @ApiResponse(code = 200, message = "get all customer"),
			@ApiResponse(code = 405, message = "bad request,not proper car data") })

	@GetMapping("/allcustomer")
	public List<Customer> getAllcustomer(@RequestParam String id) {
		return customerService.getAllcustomer(id);
	}

	@ApiOperation(value = "delete the customer", produces = "application/json", consumes = "application/json")
	@ApiResponses({ @ApiResponse(code = 200, message = "customer deleted"),
			@ApiResponse(code = 405, message = "bad request,not proper car data") })

	@DeleteMapping("/customer")
	public void deletecustomer(String id) {
		customerService.removecustomer(id);
	}

	@ApiOperation(value = "update the customer details", produces = "application/json", consumes = "application/json")
	@ApiResponses({ @ApiResponse(code = 200, message = "customer updated"),
			@ApiResponse(code = 405, message = "bad request,not proper car data") })

	@PutMapping("/customer")
	public Customer updatecustomerById(@RequestParam String id, @RequestBody Customer customer) {
		return customerService.updatecustomer(id, customer);
	}

	@ApiOperation(value = "to get the body ", produces = "application/json", consumes = "application/json")
	@ApiResponses({ @ApiResponse(code = 200, message = "body obtained"),
			@ApiResponse(code = 405, message = "bad request,not proper car data") })

	@GetMapping("/hello")
	public Customer get() {
		return new Customer();
	}
}
