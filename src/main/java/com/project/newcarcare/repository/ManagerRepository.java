package com.project.newcarcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.newcarcare.dto.Manager;

public interface ManagerRepository extends JpaRepository<Manager, String> {

}
