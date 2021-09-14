package com.ibm.training.spring.boot.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ibm.training.spring.boot.jpa.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
	
	List<Student> findByFirstName(String firstName);
	List<Student> findByEmail(String email);
	
	@Query(value = "select s from Student s where id = :id")
	Student getStudentById(Long id);
	
	@Query(value = "select * from students s where id = :id", nativeQuery = true)
	Student getStudentByIdNativeQuery(Long id);
	
}
