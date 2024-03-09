package com.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Expenditures {
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int expenditure_id;
	 	

	 	 @ManyToOne
	     @JoinColumn(name = "ngo_id")
	 	 @JsonBackReference
	     private Ngos ngo;
	 	 
	 	@Column(name = "Amount")
	    private int exp_amount;
	    
	    private String description;
	    
	    private LocalDateTime expenditureDate;
	
}
