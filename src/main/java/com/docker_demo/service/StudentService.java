package com.docker_demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.docker_demo.entity.Student;
import com.docker_demo.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

	public Student registerStudent(Student student) {
		return studentRepository.save(student);
	}

	public Student findStudentByFirstName(String firstName) {
		return studentRepository.findByFirstName(firstName);
	}

	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}
}
