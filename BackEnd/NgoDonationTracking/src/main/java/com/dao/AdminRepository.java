package com.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
	
	@Query("select a from Admin a where a.email=:e")
	List<Admin> findByEmail(@Param("e") String email);
//	public List<Admin>find(@Param("e")String email);
	public List<Admin>findByName(String name);

}
