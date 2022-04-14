package com.project.newcarcare.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.newcarcare.dto.Branch;

public interface BranchRepository extends JpaRepository<Branch, String> {

	@Query("select b from Branch b where b.manager.id=?1")
	public List<Branch> getAll(String id) ;
}
