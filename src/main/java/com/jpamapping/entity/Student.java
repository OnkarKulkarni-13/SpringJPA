package com.jpamapping.entity;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer studentId;

	String studentName;

	String about;

	@OneToMany(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Fetch(FetchMode.JOIN)
	List<Laptop> laptop = new ArrayList<>();

//	@OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
//	Address address;

}
