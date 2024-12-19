package com.jpamapping.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jpamapping.entity.Laptop;
import com.jpamapping.entity.Student;
import com.jpamapping.repo.LaptopRepo;
import com.jpamapping.repo.StudentRepo;

@RestController
public class LaptopController {
	@Autowired
	LaptopRepo laptopRepo;

	@Autowired
	StudentRepo studentRepo;

	@GetMapping("/laptop")
	public List<Laptop> getAllLaptops() {

		return laptopRepo.findAll();

	}

	@PostMapping("/laptop")
	public Laptop addLaptop(@RequestBody Laptop laptop) {
		if (laptop.getStudent() != null) {
			if (laptop.getStudent().getStudentId() == null) {
				studentRepo.save(laptop.getStudent());
				System.out.println("New Student Created " + laptop.getStudent().toString());
				laptop.setStudent(laptop.getStudent());

			} else {
				System.out.println("Student I'd is Provided :-> Finding Student Exsist or NOT");
				Optional<Student> studentById = studentRepo.findById(laptop.getStudent().getStudentId());
				if (studentById.isPresent())
					System.out.println("Printing Existing Student Created " + studentById.get().toString());

				laptop.setStudent(studentById.get());
			}
		}

		return laptopRepo.save(laptop);

	}

}
