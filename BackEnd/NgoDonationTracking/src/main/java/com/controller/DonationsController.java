package com.controller;


import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.model.Donations;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import com.service.DonationsService;


@RestController
@RequestMapping("/donations")
@CrossOrigin(origins = "http://localhost:4200")

public class DonationsController {
    @Autowired
    private DonationsService donationService;
    
    @PostMapping
    public ResponseEntity<Donations> saveDonation(@RequestBody Donations donation) {
    	Donations savedDonation = donationService.saveDonation(donation);
    	return ResponseEntity.status(HttpStatus.CREATED).header("Save", "Donation saved").body(savedDonation);
    }
    
    

    @PostMapping("/donate")
    @ResponseBody
    public String createOrder(@RequestBody Map<String, Object> data) throws RazorpayException {
    	System.out.println(data);
    	int amount =Integer.parseInt(data.get("amount").toString());
    	  var client = new RazorpayClient("rzp_test_M1sggR7jCFARkD", "qJRkoqROnGoEBnnQV510FyQW");
          JSONObject ob = new JSONObject();
          ob.put("amount", amount * 100);
          ob.put("currency", "INR");
          ob.put("receipt", "txn_555123");
          Order order = client.orders.create(ob);
          System.out.println(order);

          Order d = client.orders.create(ob);
          return d.toString();
    }
	

	
	
    @GetMapping("/getDonation/{id}")
    public ResponseEntity<Donations> getDonationById(@PathVariable int id) {
    	Donations donation=donationService.getDonationsById(id);
    	return donation != null
                ?  ResponseEntity.status(HttpStatus.OK).body(donation)
                :  ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);  
    }
    
    @GetMapping("/getAllDonations")
    public ResponseEntity<List<Donations>> getAllDonations() {
    	List<Donations> donations = donationService.getAllDonations();
        return ResponseEntity.status(HttpStatus.OK).body(donations);
    }
    
    @GetMapping("/getDonationsByUserId/{userId}")
    public ResponseEntity<List<Donations>> getAllDonationsByUserId(@PathVariable int userId) {
        List<Donations> donations = donationService.getAllDonationsByUserId(userId);
        return ResponseEntity.ok(donations);
    }
    
    @GetMapping("/getDonationsByNgoId/{ngoId}")
    public ResponseEntity<List<Donations>> getAllDonationsByNgoId(@PathVariable int ngoId) {
        List<Donations> donations = donationService.getAllDonationsByNgoId(ngoId);
        return ResponseEntity.ok(donations);
    }

    @DeleteMapping("/{donation_id}")
    public ResponseEntity<Void> deleteDonation(@PathVariable("donation_id") int id) {
    	
    	donationService.deleteDonation(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }
}

