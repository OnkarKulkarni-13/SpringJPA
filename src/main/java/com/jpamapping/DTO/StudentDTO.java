package com.jpamapping.DTO;

import java.util.List;

import com.jpamapping.entity.Laptop;

import lombok.Data;

@Data
public class StudentDTO {

	int studentId;

	String studentName;

	String about;

	List<Laptop> laptop;

}
