package com.RushikeshAssignment.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.RushikeshAssignment.Entity.lead;
import com.RushikeshAssignment.Service.leadService;
import com.RushikeshAssignment.Status.APIError;
import com.RushikeshAssignment.Status.errorResponse;
import com.RushikeshAssignment.Status.successResponse;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/leads")
@Valid
public class leadController {
	
	@Autowired 
	private leadService LeadService;
	
	@PostMapping
    public ResponseEntity<?> createLead(@Valid @RequestBody lead leads) {
        if (LeadService.isLeadIdExists(leads.getId())) {
            // Return error response if leadId already exists
            errorResponse errorResponse = new errorResponse("E10010", "Lead Already Exists in the database with the lead id");
            return new ResponseEntity<>(new APIError("error", errorResponse), HttpStatus.BAD_REQUEST);
        }

        LeadService.saveLead(leads);
        successResponse successResponse = new successResponse("success", "Created Leads Successfully");
        return new ResponseEntity<>(successResponse, HttpStatus.CREATED);
    }
    
    @GetMapping("/byMobileNumber/{mobileNumber}")
    public ResponseEntity<Object> getLeadsByMobileNumber(@PathVariable String mobileNumber) {
        List<lead> leads = LeadService.getLeadsByMobileNumber(mobileNumber);

        if (leads.isEmpty()) {
            // Return a response with a proper message if no leads are found
        	errorResponse errorResponse = new errorResponse("E10020", "No leads found with the given mobile number");
            return new ResponseEntity<>(new APIError("error", errorResponse), HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(leads, HttpStatus.OK);
            
            
        }
    }
	
	
	
	
	
	

}
