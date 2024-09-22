package com.docker_demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.docker_demo.entity.Student;
import com.docker_demo.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@PostMapping("/register")
	public ResponseEntity<Student> registerStudent(@RequestBody Student student) {
		Student result = studentService.registerStudent(student);
		return ResponseEntity.status(HttpStatus.CREATED).body(result);
	}

	@GetMapping("/findAll")
	public ResponseEntity<List<Student>> findAllStudents() {
		List<Student> students = studentService.getAllStudents();
		return ResponseEntity.status(HttpStatus.OK).body(students);

	}

	@GetMapping("/findByFirstName")
	public ResponseEntity<Student> findByFirstName(@RequestParam("firstName") String firstName) {
		Student student = studentService.findStudentByFirstName(firstName);
		return ResponseEntity.status(HttpStatus.OK).body(student);
	}

}
