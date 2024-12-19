package com.jpamapping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jpamapping.entity.Student;
import com.jpamapping.repo.StudentRepo;

@RestController
public class StudentController {

	@Autowired
	StudentRepo studentRepo;

	@GetMapping("/student")
	public List<Student> getAllStudents() {

		List<Student> allStudents = studentRepo.findAll();

		System.out.println("Printing all the students :->" + allStudents.toString());

		return allStudents;

	}

	@PostMapping("/student")
	public Student addStudent(@RequestBody Student student) {

		System.out.println(student);

		student.getLaptop().forEach(laptop -> {
			laptop.setStudent(student);
		});

		// student.getAddress().setStudent(student);

		return studentRepo.save(student);

	}

	@DeleteMapping("/student/{id}")
	public String deleteStudent(@PathVariable Integer id) {
		studentRepo.deleteById(id);
		return "Student with Id" + id + "Deleted";
	}

}
