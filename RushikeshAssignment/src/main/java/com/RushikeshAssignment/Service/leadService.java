package com.RushikeshAssignment.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RushikeshAssignment.Entity.lead;
import com.RushikeshAssignment.Repository.leadRepository;

import jakarta.validation.Valid;

@Service
public class leadService {
	
	@Autowired
	private leadRepository leadrepository;

	public  boolean isLeadIdExists(int id) {
		
		return leadrepository.existsById(id) ;
	}

	public void saveLead(lead leads) {
		leadrepository.save(leads);
	}

	public  List<lead> getLeadsByMobileNumber(String mobileNumber) {
		
		return leadrepository.findByMobileNumber(mobileNumber);
	}


	
	
	
	

}
