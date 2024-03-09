package com.model;

import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity

@NoArgsConstructor
@AllArgsConstructor
public class Ngos {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ngo_id;

    @Column(name = "name", unique = true)
    private String name;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "ngo", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Expenditures> expenditures;

	public int getNgo_id() {
		return ngo_id;
	}

	public void setNgo_id(int ngo_id) {
		this.ngo_id = ngo_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Expenditures> getExpenditures() {
		return expenditures;
	}

	public void setExpenditures(List<Expenditures> expenditures) {
		this.expenditures = expenditures;
	}
    
}
