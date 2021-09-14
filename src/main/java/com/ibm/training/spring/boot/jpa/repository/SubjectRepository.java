package com.ibm.training.spring.boot.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ibm.training.spring.boot.jpa.entity.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Long> {

}
