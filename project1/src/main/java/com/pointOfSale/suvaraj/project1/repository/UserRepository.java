package com.pointOfSale.suvaraj.project1.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pointOfSale.suvaraj.project1.entity.User;

public interface UserRepository extends JpaRepository<User, Long > {

	public Optional<User> findByEmail(String email);
	
}
