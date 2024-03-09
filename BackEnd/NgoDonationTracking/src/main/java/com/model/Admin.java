package com.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
// admin
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Admin {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int admin_id;
	
	private String name;

    private String username;

    private String password;

    private String email;

}
