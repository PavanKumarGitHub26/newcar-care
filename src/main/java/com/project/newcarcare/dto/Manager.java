package com.project.newcarcare.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Manager {

	@Id
	private String id;
	private String name;
	private String email;
	private String password;
	private long number;
	
}
