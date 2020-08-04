package com.project.sector.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.project.sector.dto.CompanyDTO;
import com.project.sector.service.SectorService;


import java.util.*;
@RestController
 public class SectorController {
	public SectorController(SectorService service, CompanyEntity companyEntity) {
		super();
		this.service = service;
		this.companyEntity = companyEntity;
	}
	SectorService service;
	CompanyEntity companyEntity;
	
	@HystrixCommand(fallbackMethod= "defaultResponse")
	@RequestMapping(value="/sector_stock_price/{sector_id}/{from}/{ to}/{period}",  method=RequestMethod.GET,  produces=MediaType.APPLICATION_JSON_VALUE)
	public  ResponseEntity<Iterable<Double>> getSectorPrice(@PathVariable Long sectorId,@PathVariable  Date from,@PathVariable  Date to,@PathVariable  int period) {
		String sector=service.getSectorName(sectorId);
		return companyEntity.getSectorPrice(sector, from, to, period);
	}
    
	@HystrixCommand(fallbackMethod= "defaultResponse")
	@RequestMapping(value="sector/{sectorId}",  method=RequestMethod.GET,  produces=MediaType.APPLICATION_JSON_VALUE)
	public  ResponseEntity<List<CompanyDTO>> getCompanyList(@PathVariable Long sectorId) {
		
		String sector=service.getSectorName(sectorId);
		System.out.println(sector);
		Iterable<CompanyDTO> dto=companyEntity.getCompanyDetailsBySector(sector);
		List<CompanyDTO> list=new ArrayList<>();
		for(CompanyDTO companyDTO:dto)
			list.add(companyDTO);
		
		return new ResponseEntity(list,HttpStatus.OK);
	}
	
	
	// When we define a fallback-method, the fallback-method must match the same parameters of the method where you define the Hystrix Command using the hystrix-command annotation.
	public ResponseEntity<String> defaultResponse(String err) {
		System.out.println("You are seeing this fallback response because the underlying microservice is down.");
		err = "Fallback error as the microservice is down.";
		return new ResponseEntity<>(err, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
