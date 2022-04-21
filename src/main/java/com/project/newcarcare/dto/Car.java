package com.project.newcarcare.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity

public class Car {

	@Id
	private String carNumber;
	private String model;
	private String brand;
	private String type;
	private String color;
	private int manufactureYear;
	
	@ManyToOne
	@JoinColumn
	private Customer customer;
	
	@OneToMany(mappedBy = "car")
	private List<ServiceSelected> serviceSelecteds;

	public String getCarNumber() {
		return carNumber;
	}

	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getManufactureYear() {
		return manufactureYear;
	}

	public void setManufactureYear(int manufactureYear) {
		this.manufactureYear = manufactureYear;
	}
	@JsonIgnore
	public Customer getCustomer() {
		return customer;
	}
	
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<ServiceSelected> getCarServices() {
		return serviceSelecteds;
	}

	public void setCarServices(List<ServiceSelected> serviceSelecteds) {
		this.serviceSelecteds = serviceSelecteds;
	}
	
	
}
