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

import com.project.newcarcare.Service.BranchService;
import com.project.newcarcare.Service.ManagerService;
import com.project.newcarcare.dto.Branch;
import com.project.newcarcare.dto.Manager;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class BranchController {

	@Autowired
	BranchService branchService;

	@ApiOperation(value = "save branch details", produces = "application/json", consumes = "application/json")
	@ApiResponses({ @ApiResponse(code = 200, message = "branch saved"),
			@ApiResponse(code = 405, message = "bad request,not proper car data") })


	@PostMapping("/manager/{mid}/branch")
	public Branch saveBranch(@PathVariable String mid, @RequestBody Branch branch) {
		return branchService.savebranch(mid, branch);
	}
	@ApiOperation(value = "get branch details", produces = "application/json", consumes = "application/json")
	@ApiResponses({ @ApiResponse(code = 200, message = " get branch "),
			@ApiResponse(code = 405, message = "bad request,not proper car data") })


	@GetMapping("/branch")
	public Branch getBranchById(@RequestParam String id) {
		return branchService.getbranch(id);
	}
	@ApiOperation(value = "get all branch details", produces = "application/json", consumes = "application/json")
	@ApiResponses({ @ApiResponse(code = 200, message = " get  all branch "),
			@ApiResponse(code = 405, message = "bad request,not proper car data") })

	@GetMapping("/branchs")
	public List<Branch> getAllBranch(@RequestParam String id) {
		return branchService.getAllbranch(id);
	}
	@ApiOperation(value = "delete branch" , produces = "application/json", consumes = "application/json")
	@ApiResponses({ @ApiResponse(code = 200, message = " branch deleted"),
			@ApiResponse(code = 405, message = "bad request,not proper car data") })

	@DeleteMapping("/branch")
	public boolean deleteBranch(String id) {
		return branchService.removebranch(id);
	}
	@ApiOperation(value = "update branch details", produces = "application/json", consumes = "application/json")
	@ApiResponses({ @ApiResponse(code = 200, message = " branch updated"),
			@ApiResponse(code = 405, message = "bad request,not proper car data") })


	@PutMapping("/branch")
	public Branch updateBranchById(@RequestParam String id, @RequestBody Branch branch) {
		return branchService.updatebranch(id, branch);
	}
	@ApiOperation(value = "get branch body", produces = "application/json", consumes = "application/json")
	@ApiResponses({ @ApiResponse(code = 200, message = " get branch "),
			@ApiResponse(code = 405, message = "bad request,not proper car data") })


	@GetMapping("getbranch")
	public Branch get() {
		return new Branch();
	}
}
