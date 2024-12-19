package com.jpamapping.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Laptop {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int laptopId;

	String brand;

	String modelNumber;

	@ManyToOne
	@JoinColumn(name = "studentId")
	@JsonBackReference
	// @JsonIgnore
	Student student;
	
	public String toString() {
		return "Laptop{" + "laptopId=" + laptopId + ", brand='" + brand + '\'' + '}';
	}
}
