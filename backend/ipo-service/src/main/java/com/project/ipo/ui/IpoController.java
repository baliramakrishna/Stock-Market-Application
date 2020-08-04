package com.project.ipo.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.ipo.model.IpoEntity;
import com.project.ipo.model.dto.IpoDTO;
import com.project.ipo.repository.IpoRepository;
import com.project.ipo.service.IpoService;

@RestController
public class IpoController {
    
	@Autowired
	IpoRepository repo;
	@Autowired
	IpoService service;
	
	
	@RequestMapping(value="/{company_name}",  method=RequestMethod.GET,  produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<IpoDTO> getCompanyIPODetails(@PathVariable String company_name){
		
		return ResponseEntity.status(HttpStatus.OK).body(service.getCompanyIPODetails(company_name));
	}
	
	
}
