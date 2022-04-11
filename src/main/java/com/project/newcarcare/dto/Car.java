package com.project.newcarcare.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Car {

	@Id
	private String carNumber;
	private String model;
	private String brand;
	private String type;
	private String color;
	private int manufactureYear;

}
