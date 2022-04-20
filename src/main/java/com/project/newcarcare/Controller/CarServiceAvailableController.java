package com.project.newcarcare.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.newcarcare.Service.CarServiceAvailableService;
import com.project.newcarcare.dto.CarServiceAvailable;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class CarServiceAvailableController {
	@Autowired
	CarServiceAvailableService carServiceAvailableService;

	@ApiOperation(value = "save carserviceavailable details", produces = "application/json", consumes = "application/json")
	@ApiResponses({ @ApiResponse(code = 200, message = "carserviceavailable saved"),
			@ApiResponse(code = 405, message = "bad request,not proper service data") })

	@PostMapping("/manager/{mid}/serviceavailable")
	public CarServiceAvailable saveCarServiceAvailable(@PathVariable String mid,
			@RequestBody CarServiceAvailable carServiceAvailable) {
		return carServiceAvailableService.saveCarServiceAvailable(mid, carServiceAvailable);
	}

	@ApiOperation(value = "getcarserviceavailable details", produces = "application/json", consumes = "application/json")
	@ApiResponses({ @ApiResponse(code = 200, message = " get carserviceavailable "),
			@ApiResponse(code = 405, message = "bad request,not proper car data") })

	@GetMapping("/serviceavailable")
	public CarServiceAvailable getCarServiceAvailableById(@RequestParam int id) {
		return carServiceAvailableService.getCarServiceAvailable(id);
	}

	@ApiOperation(value = "get allcarserviceavailable details", produces = "application/json", consumes = "application/json")
	@ApiResponses({ @ApiResponse(code = 200, message = " get  all carserviceavailable "),
			@ApiResponse(code = 405, message = "bad request,not proper car data") })

	@GetMapping("/getallserviceavailable")
	public List<CarServiceAvailable> getAllCarServiceAvailable() {
		return carServiceAvailableService.getAllCarServiceAvailable();
	}

	@ApiOperation(value = "delete allcarserviceavailable", produces = "application/json", consumes = "application/json")
	@ApiResponses({ @ApiResponse(code = 200, message = " allcarserviceavailable deleted"),
			@ApiResponse(code = 405, message = "bad request,not proper car data") })

	@DeleteMapping("/serviceavailable")
	public boolean deletecarServiceAvailable(int id) {
		return carServiceAvailableService.removeCarServiceAvailable(id);
	}

	
	@ApiOperation(value = "update allcarserviceavailable details", produces = "application/json", consumes = "application/json")
	@ApiResponses({ @ApiResponse(code = 200, message = " allcarserviceavailable updated"),
			@ApiResponse(code = 405, message = "bad request,not proper car data") })

	@PutMapping("/serviceavailable")
	public CarServiceAvailable updateCarServiceAvailablehById(@RequestParam int id,
			@RequestBody CarServiceAvailable carServiceAvailable) {
		return carServiceAvailableService.updateCarServiceAvailable(id, carServiceAvailable);
	}

	@GetMapping("/hmm")
	public CarServiceAvailable get() {
		return new CarServiceAvailable();
	}

}
