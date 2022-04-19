package com.project.newcarcare.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.newcarcare.dao.BranchDao;
import com.project.newcarcare.dao.ManagerDao;
import com.project.newcarcare.dto.Branch;

@Service
public class BranchService {

	@Autowired
	ManagerDao dao;

	@Autowired
	BranchDao branchDao;

	public Branch savebranch(String id, Branch branch) {
		return branchDao.saveBranch(id, branch);
	}

	public Branch getbranch(String id) {
		Branch branch = branchDao.getBranch(id);
		if (branch == null) {
			return null;
		}
		return branch;
	}

	public List<Branch> getAllbranch(String id) {
		return branchDao.getAll(id);
	}

	public boolean removebranch(String id) {
		Branch branch = branchDao.getBranch(id);
		if (branch != null) {
			branchDao.removeBranch(id);
			return true;
		} else
			return false;
	}

	public Branch updatebranch(String id, Branch m1) {
		Branch branch = branchDao.getBranch(id);
		if (branch != null) {
			return branchDao.updateBranch(id, m1);
		}
		return null;
	}
}
