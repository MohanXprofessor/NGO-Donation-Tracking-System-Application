package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.model.Ngos;
import com.service.NgosService;

import java.util.List;

@RestController
@RequestMapping("/ngos")
@CrossOrigin(origins = "http://localhost:4200")

public class NgosController {
    @Autowired
    private NgosService ngoService;
    
    @PostMapping
    public ResponseEntity<Ngos> saveNgo(@RequestBody Ngos ngo) {
    	Ngos savedNgo = ngoService.saveNgo(ngo);
    	return ResponseEntity.status(HttpStatus.CREATED).header("Save", "Ngo saved").body(savedNgo);
    }

    @GetMapping("/getAllNgos")
    public ResponseEntity<List<Ngos>> getAllNgos() {
    	List<Ngos> ngos = ngoService.getAllNgos();
        return ResponseEntity.status(HttpStatus.OK).body(ngos);
    }    

    //findById
    @GetMapping("/getNgo/{id}")
    public ResponseEntity<Ngos> getNgoById(@PathVariable("id")  int id) {
    	Ngos ngo=ngoService.getNgoById(id);
    	return ngo != null
                ?  ResponseEntity.status(HttpStatus.OK).body(ngo)
                :  ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);  
    }
    
    //findByName change
    
    @GetMapping("/getNgobyname/{name}")
    public ResponseEntity<Ngos> getNgoByName(@PathVariable String name) {
    	Ngos ngo=ngoService.getNgoByName(name);
    	return ngo != null
                ?  ResponseEntity.status(HttpStatus.OK).body(ngo)
                :  ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);  
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ngos> updateNgo(@PathVariable int id, @RequestBody Ngos updatedNgo) {
        Ngos ngo = ngoService.updateNgo(id, updatedNgo);
        return ngo != null
        		?  ResponseEntity.status(HttpStatus.OK).body(ngo)
                :  ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNgo(@PathVariable int id) {
    	ngoService.deleteNgo(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }
    
}  
    
    
    
    
    
    
// @PostMapping("/{ngoId}/image")   
//    public ResponseEntity<String> saveNgoImage(@PathVariable int ngoId, @RequestParam("image") MultipartFile imageFile) throws Exception {
//        ngoService.saveNgoImage(ngoId, imageFile);
//        return ResponseEntity.ok("NGO image saved successfully");
//    }


