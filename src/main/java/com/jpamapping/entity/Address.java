package com.jpamapping.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Address {
	@Id
	int addressId;

	String address;

	@OneToOne
	@JoinColumn(name = "student_id")
	@JsonBackReference
	Student student;

}
