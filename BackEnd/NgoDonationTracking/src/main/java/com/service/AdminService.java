package com.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.AdminRepository;
import com.dao.ExpenditureRepository;
import com.dao.NgosRepository;
import com.model.Admin;
import com.model.Expenditures;
import com.model.Ngos;

import jakarta.transaction.Transactional;


@Service
public class AdminService {
	
	@Autowired
    private AdminRepository adminRepository;
	
	 @Autowired
	    private NgosRepository ngosRepository;
	 
	 @Autowired
	    private ExpenditureRepository expenditureRepository;

    public Admin saveAdmin(Admin admin) {
        return adminRepository.save(admin);
    }
    
    public Admin getAdminById(int id) {
        return adminRepository.findById(id).orElse(null);
    }
    
    public List<Admin> getAllAdmin() {
        return adminRepository.findAll();
    }

    public Admin updateAdmin(int id, Admin updatedAdmin) {
    	Admin existingAdmin = adminRepository.findById(id).orElse(null);
        if (existingAdmin != null) {
        	existingAdmin.setUsername(updatedAdmin.getUsername());
        	existingAdmin.setPassword(updatedAdmin.getPassword());
        	existingAdmin.setEmail(updatedAdmin.getEmail());

            return adminRepository.save(existingAdmin);
        }

        return null;
    }
    public void deleteAdmin(int id) {
    	Admin existingAdmin=adminRepository.findById(id).orElse(null);
    	adminRepository.delete(existingAdmin);
    }
    
    public List<Admin> find(String email) {
		// TODO Auto-generated method stub
		return adminRepository.findByEmail(email);
	}


	public List<Admin> findByName(String name) {
		// TODO Auto-generated method stub
		return adminRepository.findByName(name);
	}
	
	

	    // ... (existing methods)

	@Transactional
    public void deleteNgoByAdmin(int ngoId) {
        Ngos ngo = ngosRepository.findById(ngoId).orElse(null);

        if (ngo != null) {
            List<Expenditures> expenditures = ngo.getExpenditures();
            ngo.setExpenditures(null);
            ngosRepository.save(ngo);
            expenditures.forEach(expenditure -> expenditureRepository.delete(expenditure));
          ngosRepository.delete(ngo);
        }
    }

	    public Ngos updateNgoByAdmin(int adminId, int ngoId, Ngos updatedNgo) {
	        Admin admin = adminRepository.findById(adminId).orElse(null);
	        if (admin != null) {
	            Ngos existingNgo = ngosRepository.findById(ngoId).orElse(null);
	            if (existingNgo != null) {
	                // Only update the name if it's provided in the request
	                if (updatedNgo.getName() != null) {
	                    existingNgo.setName(updatedNgo.getName());
	                }

	                // Only update the description if it's provided in the request
	                if (updatedNgo.getDescription() != null) {
	                    existingNgo.setDescription(updatedNgo.getDescription());
	                }

	                return ngosRepository.save(existingNgo);
	            }
	        }
	        return null;
	    }

}
