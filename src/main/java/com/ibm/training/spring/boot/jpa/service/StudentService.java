package com.ibm.training.spring.boot.jpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.training.spring.boot.jpa.entity.Student;
import com.ibm.training.spring.boot.jpa.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository repository;
	
	
	public List<Student> fetchAll(){
		return repository.findAll();
	}
	
	public Student findById(Long id) {
		if(id == null) {
			return new Student();
		}
		long studentId = id;
		if(studentId>10) {
			return new Student();
		}
		Optional<Student> optional = repository.findById(id);
		Student student = optional.isPresent()?optional.get():null;
		String gender = student.getGender();
		student.setFirstName(gender.equalsIgnoreCase("male")?"Mr. "+student.getFirstName():"Miss. "+student.getFirstName());
		return student;
	}
	
	public void save(Student student) {
		repository.save(student);
	}
	
	public void update(Student student, Long id) {
		student.setId(id);
		repository.save(student);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}

}
