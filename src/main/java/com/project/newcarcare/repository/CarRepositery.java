package com.project.newcarcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.newcarcare.dto.Car;

public interface CarRepositery extends JpaRepository<Car, String> {

}
