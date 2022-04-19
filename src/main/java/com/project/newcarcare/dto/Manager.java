package com.project.newcarcare.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;


import lombok.Data;

@Entity
@Data
public class Manager {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "manager_seq")
	@GenericGenerator(
			name="manager_seq",
			strategy = "com.project.newcarcare.dto.StringPrefixedSequenceIdGenerator",
			parameters = {
					@Parameter(name=StringPrefixedSequenceIdGenerator.INCREMENT_PARAM,value = "1"),
					@Parameter(name=StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER,value="MG_"),
					@Parameter(name=StringPrefixedSequenceIdGenerator.VALUE_FORMAT_PARAMETER,value="%05d")
			}
			
			)
	
	
	
	private String id;
	private String name;
	private String email;
	private String password;
	private long number;
	
	@OneToMany(mappedBy = "manager") 
	private List<Branch>branchs;
	
}
