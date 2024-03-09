package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.model.Users;

public interface UserRepository extends JpaRepository<Users, Integer> {
	@Query("SELECT u FROM Users u WHERE u.username = :username")
	Users getUserByName(String username);
}
