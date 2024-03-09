package com.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.model.Ngos;

public interface NgosRepository extends JpaRepository<Ngos, Integer> {
    

    @Query("SELECT n FROM Ngos n WHERE n.name = :name")
	Ngos getNgoByName(String name);
}
