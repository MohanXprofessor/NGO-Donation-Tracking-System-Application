package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.ExpenditureRepository;
import com.dao.NgosRepository;
import com.model.Expenditures;
import com.model.Ngos;

@Service
public class ExpenditureService {
	  @Autowired
	    private NgosRepository ngosRepository;
    @Autowired
    private ExpenditureRepository expenditureRepository;
    
    public Expenditures saveExpenditure(Expenditures expenditure) {
        return expenditureRepository.save(expenditure);
    }

    public List<Expenditures> getAllExpenditures() {
        return expenditureRepository.findAll();
    }

    public Expenditures getExpenditureById(int id) {
        return expenditureRepository.findById(id).orElse(null);
    }
  
    public void deleteExpenditure(int id) {
    	Expenditures existingExpenditure=expenditureRepository.findById(id).orElse(null);
    	expenditureRepository.delete(existingExpenditure);
    }
}/* public Expenditures addExpenditureToNgoByName(String ngoName, Expenditures expenditure) {
        // Retrieve the NGO entity from the repository based on its name
        Optional<Ngos> optionalNgo = ngosRepository.findByName(ngoName);
        if (optionalNgo.isPresent()) {
            Ngos ngo = optionalNgo.get();
            expenditure.setNgo(ngo); // Set the NGO for the expenditure
            // You can perform additional validation or business logic here before saving the expenditure
            return expenditureRepository.save(expenditure); // Save the expenditure and return the created entity
        } else {
           return null;
        }
    }
*/
