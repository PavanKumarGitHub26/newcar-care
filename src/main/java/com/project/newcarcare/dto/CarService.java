package com.project.newcarcare.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


import lombok.Data;

@Data
@Entity
public class CarService {

@Id
private int id;
private String type;
private double cost;
private String duration;



	@ManyToOne
	private Branch branch;

	@ManyToOne
	@JoinColumn
	private Car car;
	
	@ManyToOne
	@JoinColumn
	private Manager manager;
}
