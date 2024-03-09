package com.model;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
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
public class Users {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int user_id;
	
	private String username; //firsstName and lastName

    private String password;

    private String email;
    
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    
    private Set<Donations> donations;

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Donations> getDonations() {
		return donations;
	}

	public void setDonations(Set<Donations> donations) {
		this.donations = donations;
	}

	@Override
	public String toString() {
		return "Users [user_id=" + user_id + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", donations=" + donations + "]";
	}
    

}
