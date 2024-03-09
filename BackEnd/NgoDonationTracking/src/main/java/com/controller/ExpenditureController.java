package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.model.Expenditures;
import com.service.ExpenditureService;

import java.util.List;

@RestController
@RequestMapping("/expenditures")
@CrossOrigin(origins = "http://localhost:4200")

public class ExpenditureController {
    @Autowired
    private ExpenditureService expenditureService;

    @PostMapping
    public ResponseEntity<Expenditures> saveExpenditure(@RequestBody Expenditures expenditure) {
    	Expenditures savedExpenditure = expenditureService.saveExpenditure(expenditure);
    	return ResponseEntity.status(HttpStatus.CREATED).header("Save", "Expenditure saved").body(savedExpenditure);
    }
    
    @GetMapping("/getExpenditure/{id}")
    public ResponseEntity<Expenditures> getExpenditureById(@PathVariable("id") int id) {
    	Expenditures expenditure=expenditureService.getExpenditureById(id);
    	return expenditure != null
                ?  ResponseEntity.status(HttpStatus.OK).body(expenditure)
                :  ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);  
    }
    
    @GetMapping("/getAllExpenditures")
    public ResponseEntity<List<Expenditures>> getAllNgos() {
    	List<Expenditures> expenditure = expenditureService.getAllExpenditures();
        return ResponseEntity.status(HttpStatus.OK).body(expenditure);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExpenditure(@PathVariable int id) {
    	expenditureService.deleteExpenditure(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

}

//  @PostMapping("/{ngoName}")
//public ResponseEntity<Expenditures> addExpenditureToNgoByName(@PathVariable("ngoName") String ngoName,
//        @RequestBody Expenditures expenditure) {
//Expenditures createdExpenditure = expenditureService.addExpenditureToNgoByName(ngoName, expenditure);
//return new ResponseEntity<>(createdExpenditure, HttpStatus.CREATED);
//}
