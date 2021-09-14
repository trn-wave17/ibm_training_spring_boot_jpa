package com.ibm.training.spring.boot.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ibm.training.spring.boot.jpa.entity.Student;
import com.ibm.training.spring.boot.jpa.entity.StudentProfile;
import com.ibm.training.spring.boot.jpa.entity.Subject;
import com.ibm.training.spring.boot.jpa.entity.User;
import com.ibm.training.spring.boot.jpa.repository.StudentProfileRepository;
import com.ibm.training.spring.boot.jpa.repository.StudentRepository;
import com.ibm.training.spring.boot.jpa.repository.SubjectRepository;
import com.ibm.training.spring.boot.jpa.repository.UserRepository;

@SpringBootApplication
public class SpringBootJpaRepositoryApplication implements CommandLineRunner {
	
	@Autowired
	private StudentRepository studentRepsitory;
	
	@Autowired
	private SubjectRepository subjectRepository;
	
	@Autowired
	private StudentProfileRepository profileRepository;
	
	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaRepositoryApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		User user = new User("divyansh", "$2a$12$k3sxjixwq5vXpqxi8o6RauTOX6q3azWNXgHYfpoSFGqY31bLqMW8W");
		userRepository.save(user);
		
		Subject maths = new Subject("Maths", "UMA001");
		Subject cprogramming = new Subject("C Programming", "UCS001");
		Subject electronics = new Subject("Electronics", "UEC001");
		
		StudentProfile sp1 = new StudentProfile(30, "India");
		StudentProfile sp2 = new StudentProfile(32, "Malaysia");
		
		Student student = new Student("Divyansh", "Awasthi", "divyansh.awasthi@gmail.com", "Male", 200, List.of(maths, cprogramming),sp1);
		Student student1 = new Student("Seema", "Khan", "seema.khan@gmail.com", "Female", 200, List.of(maths, electronics),sp2);
		
		maths.setStudents(List.of(student, student1));
		cprogramming.setStudents(List.of(student));
		electronics.setStudents(List.of(student1));
		
		Student response1 =  studentRepsitory.save(student);
		Student response2 = studentRepsitory.save(student1);
		System.out.println(response1);
		System.out.println(response2);
		
		Student response3 = studentRepsitory.getStudentById(2L);
		System.out.println(response3);
		
		Student response4 = studentRepsitory.getStudentByIdNativeQuery(1L);
		System.out.println(response4);
		
		Subject environment = new Subject("Environment", "UES001");
		subjectRepository.save(environment);
		
		StudentProfile sp3 = new StudentProfile(35, "India");
		profileRepository.save(sp3);
		//studentRepsitory.findById(1L).ifPresent(s->System.out.println(s));
		//studentRepsitory.deleteById(2L);
	}

}
