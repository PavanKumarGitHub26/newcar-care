package com.project.newcarcare.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.springframework.stereotype.Service;

import lombok.Data;

@Entity
@Data
public class Branch {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "manager_seq")
	@GenericGenerator(name = "manager_seq", strategy = "com.project.newcarcare.dto.StringPrefixedSequenceIdGenerator", parameters = {
			@Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
			@Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "MG_"),
			@Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_FORMAT_PARAMETER, value = "%05d") }

	)
	private String id;

	@ManyToOne
	@JoinColumn
	private Manager manager;

	@OneToMany(mappedBy = "branch")
	private List<CarService> carService;

	@OneToOne
	private Customer customer;

	private String name;
	private String area;
	private String city;
	private long phone;
	private String email;
	private String website;

}
