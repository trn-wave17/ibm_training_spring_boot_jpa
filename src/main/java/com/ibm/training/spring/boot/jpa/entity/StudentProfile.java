package com.ibm.training.spring.boot.jpa.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="student_profile")
public class StudentProfile {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="age")
	private int age;
	
	@Column(name="address", columnDefinition = "TEXT")
	private String address;
	
	//@JsonBackReference
	@JsonIgnore
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "studentProfile")
	private Student student;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public StudentProfile(int age, String address) {
		super();
		this.age = age;
		this.address = address;
	}

	public StudentProfile() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "StudentProfile [id=" + id + ", age=" + age + ", address=" + address + "]";
	}
	
	

}
