package com.ibm.training.spring.bbot.jpa.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ibm.training.spring.boot.jpa.entity.Student;
import com.ibm.training.spring.boot.jpa.repository.StudentRepository;
import com.ibm.training.spring.boot.jpa.service.StudentService;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {
	
	@Mock
	private StudentRepository studentRepository;
	
	@InjectMocks
	private StudentService service;
	
	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this);
		Student student =  new Student();
		student.setFirstName("Divyansh");
		student.setGender("Male");
		Optional<Student> optional = Optional.of(student);
		
		Mockito.lenient().when(studentRepository.findById(Mockito.anyLong())).thenReturn(optional);
	}
	
	@Test
	public void test_find_student_by_id() {
		Student student = service.findById(11L);
		//assertEquals( "Mr. Divyansh", student.getFirstName());
		//verify(studentRepository).findById(1L);
		verify(studentRepository, times(0)).findById(11L);
	}

}
