package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.DonationRepository;
import com.model.Donations;


@Service
public class DonationsService {
    @Autowired
    private DonationRepository donationRepository;

    public Donations saveDonation(Donations donation) {
        return donationRepository.save(donation);
    }
    
    public List<Donations> getAllDonations() {
        return donationRepository.findAll();
    }

    public Donations getDonationsById(int id) {
        return donationRepository.findById(id).orElse(null);
    }

    public void deleteDonation(int id) {
    	Donations existingDonation = donationRepository.findById(id).orElse(null);
    	donationRepository.delete(existingDonation);
    }
    
    public List<Donations> getAllDonationsByUserId(int user_id) {
        return donationRepository.findByUser_User_Id(user_id);
    }
    
    public List<Donations> getAllDonationsByNgoId(int ngo_id) {
        return donationRepository.findByNgo_Ngo_Id(ngo_id);
    }
}
