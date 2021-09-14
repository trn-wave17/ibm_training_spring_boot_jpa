package com.ibm.training.spring.boot.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ibm.training.spring.boot.jpa.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsername(String username);
}
