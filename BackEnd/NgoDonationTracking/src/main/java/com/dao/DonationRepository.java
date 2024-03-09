package com.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.model.Donations;

public interface DonationRepository extends JpaRepository<Donations, Integer> {

    @Query("SELECT d FROM Donations d WHERE d.user.user_id = :user_id")
    List<Donations> findByUser_User_Id(@Param("user_id") int user_id);

    @Query("SELECT d FROM Donations d WHERE d.ngo.ngo_id = :ngo_id")
    List<Donations> findByNgo_Ngo_Id(@Param("ngo_id") int ngo_id);
}
