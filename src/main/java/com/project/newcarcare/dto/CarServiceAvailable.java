package com.project.newcarcare.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.Data;
@Entity
@Data
public class CarServiceAvailable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String type;
	private double cost;
	private String duration;
	
	@ManyToOne
	@JoinColumn
	private Manager manager;
	
	@ManyToMany
	@JoinTable(inverseJoinColumns = @JoinColumn,joinColumns = @JoinColumn)
	private List<ServiceSelected> serviceSelecteds;
	
	
	
}
