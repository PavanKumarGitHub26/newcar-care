package com.project.newcarcare.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.newcarcare.dto.Branch;

import com.project.newcarcare.repository.BranchRepository;

@Repository
public class BranchDao {
	@Autowired
	BranchRepository branchRepository;

	public Branch saveBranch(Branch branch) {
		return branchRepository.save(branch);
	}

	public Branch getBranch(String id) {
		Optional<Branch> optional = branchRepository.findById(id);
		if (optional.isEmpty()) {
			return null;
		}
		Branch branch = optional.get();
		return branch;
	}

	public boolean removeBranch(String id) {
		Branch branch = getBranch(id);
		if (branch != null) {
			branchRepository.delete(branch);
			return true;
		} else
			return false;
	}

	public Branch updateBranch(String id, Branch m1) {
		Branch Branch = getBranch(id);
		if (Branch != null) {
			return branchRepository.save(Branch);
		}
		return null;
	}

	public List<Branch> getAll() {
		return branchRepository.findAll();
	}
}