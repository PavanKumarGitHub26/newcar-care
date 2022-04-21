package com.project.newcarcare.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;


import lombok.Data;

@Data
@Entity
public class CarService {

@Id
private int id;
private String type;
private double totalcost;



	@ManyToOne
	private Branch branch;

	@ManyToOne
	@JoinColumn
	private Car car;
	
	//@ManyToMany(mappedBy = "carServices")
	//private List<CarServiceAvailable> carServiceAvailables;
}
