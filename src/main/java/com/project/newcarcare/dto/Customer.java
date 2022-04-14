package com.project.newcarcare.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import lombok.Data;

@Data
@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "customer_seq")
	@GenericGenerator(
			name="customer_seq",
			strategy = "com.project.newcarcare.dto.StringPrefixedSequenceIdGenerator",
			parameters = {
					@Parameter(name=StringPrefixedSequenceIdGenerator.INCREMENT_PARAM,value = "1"),
					@Parameter(name=StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER,value="CUS_"),
					@Parameter(name=StringPrefixedSequenceIdGenerator.VALUE_FORMAT_PARAMETER,value="%05d")
			}
			
			)
	private String id;
	private String name;
	private String email;
	private String password;
	private long number;
	
	
	@OneToMany(mappedBy = "customer")
	private List<Car>car;
	
	
	
	@OneToOne
	private Branch branch;
	
}
