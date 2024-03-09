package com.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.model.Expenditures;

public interface ExpenditureRepository extends JpaRepository<Expenditures, Integer> {

	@Query("SELECT e FROM Expenditures e WHERE e.ngo.ngo_id = :ngo_id")
    List<Expenditures> findByNgo_Ngo_Id(@Param("ngo_id") int ngo_id);

}
