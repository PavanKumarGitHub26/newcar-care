package com.project.newcarcare.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


import lombok.Data;

@Data
@Entity
public class CarService {
<<<<<<< HEAD
@Id
private int id;
private String type;
private double cost;
private String duration;

=======
	@Id
	private int id;
	private String type;
	private double cost;
	private String duration;
>>>>>>> ecfd59d3b98b66dedfeb07500278a79416e905ef

	@ManyToOne
	private Branch branch;

	@ManyToOne
	@JoinColumn
	private Car car;
	
	@ManyToOne
	@JoinColumn
	private Manager manager;
}
