package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.Admin;
import com.model.Ngos;
import com.service.AdminService;

import jakarta.transaction.Transactional;


@RestController
@RequestMapping("/Admin")
@CrossOrigin(origins = "http://localhost:4200")
public class AdminCotroller {
	
	@Autowired
    private AdminService adminService;

    @PostMapping
    public ResponseEntity<Admin> saveAdmin(@RequestBody Admin user) {
    	Admin savedAdmin = adminService.saveAdmin(user);
        return ResponseEntity.status(HttpStatus.CREATED).header("Save", "Admin Saved").body(savedAdmin);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Admin>> getAllAdmin() {
        List<Admin> users = adminService.getAllAdmin();
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }

    @GetMapping("getUser/{id}")
    public ResponseEntity<Admin> getAdminById(@PathVariable int id) {
    	Admin admin = adminService.getAdminById(id);
        return admin != null
                ?  ResponseEntity.status(HttpStatus.OK).body(admin)
                :  ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Admin> updateAdmin(@PathVariable int id, @RequestBody Admin updatedAdmin) {
    	Admin admin = adminService.updateAdmin(id, updatedAdmin);
        return admin != null
        		?  ResponseEntity.status(HttpStatus.OK).body(admin)
                :  ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdmin(@PathVariable int id) {
    	adminService.deleteAdmin(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }
	
	@GetMapping("/search/{email}")
	public List<Admin> find(@PathVariable("email") String email){
		return adminService.find(email);
		
	}

	    @PutMapping("/updateNgo/{adminId}/{ngoId}")
	    public ResponseEntity<Ngos> updateNgoByAdmin(@PathVariable int adminId, @PathVariable int ngoId, @RequestBody Ngos updatedNgo) {
	        // You can use ngosService here if needed
	        Ngos ngo = adminService.updateNgoByAdmin(adminId, ngoId, updatedNgo);
	        return ngo != null
	                ? ResponseEntity.status(HttpStatus.OK).body(ngo)
	                : ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	    }
}
 


