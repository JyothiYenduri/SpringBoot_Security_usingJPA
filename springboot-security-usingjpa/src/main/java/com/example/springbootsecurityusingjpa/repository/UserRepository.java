package com.example.springbootsecurityusingjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springbootsecurityusingjpa.entity.User;



public interface UserRepository extends JpaRepository<User, Long>{
	User findByUsername(String username);

}
