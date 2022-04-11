package com.project.newcarcare.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
@Data
@Entity
public class CarService {
@Id
private int id;
private String type;
private double cost;
private String duration;


}
