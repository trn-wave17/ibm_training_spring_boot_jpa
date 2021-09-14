package com.ibm.training.spring.boot.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ibm.training.spring.boot.jpa.entity.StudentProfile;

public interface StudentProfileRepository extends JpaRepository<StudentProfile, Long> {

}
