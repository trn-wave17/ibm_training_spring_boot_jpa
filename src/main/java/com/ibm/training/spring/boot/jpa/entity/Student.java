package com.ibm.training.spring.boot.jpa.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonManagedReference;



//OnetoOne
//OnetoMany
//ManytoOne
//ManytoMany - Courses

@Entity(name = "Student")
@Table(
	name="students",
	uniqueConstraints = {
			@UniqueConstraint(name="email_unique", columnNames = "email")
	}
)
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(
		name="id",
		updatable = false
	)
	private Long id;
	
	@Column(
		name="first_name",
		nullable = false,
		columnDefinition = "TEXT"
	)
	private String firstName;
	
	@Column(
		name="last_name",
		columnDefinition = "TEXT"
	)
	private String lastName;
	
	@Column(
		name="email",
		nullable = false,
		length = 45
	)
	private String email;
	
	@Column(
		name="gender",
		nullable = false,
		columnDefinition = "TEXT"
	)
	private String gender;
	
	@Column(
		name="total_spent_in_books"
	)
	private Integer totalSpentInBooks;
	
	//@JsonManagedReference
	@ManyToMany(
		fetch = FetchType.EAGER,
		cascade = CascadeType.ALL
	)
	@JoinTable(name="stud_sub",
		joinColumns = {@JoinColumn(name="student_id")},
		inverseJoinColumns = {@JoinColumn(name="subject_id")}
	)
	private List<Subject> subjects;
	
	//@JsonManagedReference
	@OneToOne(
		fetch = FetchType.EAGER,
		cascade = CascadeType.ALL
	)
	@JoinColumn(name="sp_id", foreignKey = @ForeignKey(name = "sp_id"), referencedColumnName = "id")
	private StudentProfile studentProfile;
	
	
	
	public StudentProfile getStudentProfile() {
		return studentProfile;
	}
	public void setStudentProfile(StudentProfile studentProfile) {
		this.studentProfile = studentProfile;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Integer getTotalSpentInBooks() {
		return totalSpentInBooks;
	}
	public void setTotalSpentInBooks(Integer totalSpentInBooks) {
		this.totalSpentInBooks = totalSpentInBooks;
	}
	public List<Subject> getSubjects() {
		return subjects;
	}
	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}
	public Student(String firstName, String lastName, String email, String gender, Integer totalSpentInBooks,
			List<Subject> subjects, StudentProfile studentProfile) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.gender = gender;
		this.totalSpentInBooks = totalSpentInBooks;
		this.subjects = subjects;
		this.studentProfile = studentProfile;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", gender=" + gender + ", totalSpentInBooks=" + totalSpentInBooks + ", subjects=" + subjects + ", studentProfile=" + studentProfile +"]";
	}
	
	
	
	
	

}
