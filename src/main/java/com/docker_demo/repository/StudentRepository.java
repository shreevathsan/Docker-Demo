package com.docker_demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.docker_demo.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

	Student findByFirstName(String firstName);

}
