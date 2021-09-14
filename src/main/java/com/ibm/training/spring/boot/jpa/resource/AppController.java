package com.ibm.training.spring.boot.jpa.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.training.spring.boot.jpa.entity.Student;
import com.ibm.training.spring.boot.jpa.service.StudentService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api")
public class AppController {
	
	@Autowired
	private StudentService service;
	
	@GetMapping(value = "/students")
	@ApiOperation(value="Used to fetch all the students from database", 
		notes="This mapping is used to fetch Student data along with profile and subjects enrolled",
		response = Student.class)
	public List<Student> fetchAllStudents(){
		return service.fetchAll();
	}
	
	@GetMapping(value = "/student/{id}")
	public Student fetchStudent(@PathVariable("id") Long id){
		return service.findById(id);
	}
	
	@PostMapping(value = "/saveStudentData",consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public String saveStudentData(@RequestBody Student student) {
		service.save(student);
		return "Saved Successfully";
	}
	
	@PutMapping(value = "/editStudentData/{id}", consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public String editStudentData( @PathVariable("id") Long id, @RequestBody Student student) {
		service.update(student, id);
		return "Edited Successfully";
	}
	
	@DeleteMapping("/deleteStudentData/{id}")
	public String deleteStudentData(@PathVariable("id") Long id) {
		service.delete(id);
		return "Deleted Successfully";
	}
	

}
