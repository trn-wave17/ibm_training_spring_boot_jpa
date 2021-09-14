package com.ibm.training.spring.boot.jpa.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="subjects")
public class Subject {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(
		name = "id",
		updatable = false
	)
	private Long id;
	
	@Column(
		name = "subject_name",
		columnDefinition = "TEXT",
		nullable = false
	)
	private String subjectName;
	
	@Column(
		name = "subject_code",
		columnDefinition = "TEXT",
		nullable = false
	)
	private String subjectCode;
	
	//@JsonBackReference
	@JsonIgnore
	@ManyToMany(
		fetch = FetchType.EAGER,
		cascade = CascadeType.ALL,
		mappedBy = "subjects"
	)
	private List<Student> students;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getSubjectCode() {
		return subjectCode;
	}

	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public Subject(String subjectName, String subjectCode) {
		super();
		this.subjectName = subjectName;
		this.subjectCode = subjectCode;
	}

	public Subject() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Subject [id=" + id + ", subjectName=" + subjectName + ", subjectCode=" + subjectCode + "]";
	}
	
	
	
	
	
	
	

}
