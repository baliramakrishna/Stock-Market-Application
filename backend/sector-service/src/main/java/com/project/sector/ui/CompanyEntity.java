package com.project.sector.ui;

import java.util.Date;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient("company-service")
public interface CompanyEntity {
  
	@RequestMapping(value="sector/{sector}",  method=RequestMethod.GET,  produces=MediaType.APPLICATION_JSON_VALUE)
	public Iterable<com.project.sector.dto.CompanyDTO> getCompanyDetailsBySector(@PathVariable String sector);
	
	@RequestMapping(value="{sector_name}/{from}/{ to}/{period}",  method=RequestMethod.GET,  produces=MediaType.APPLICATION_JSON_VALUE)
	public  ResponseEntity<Iterable<Double>> getSectorPrice( @PathVariable String sector_name, @PathVariable Date from,@PathVariable  Date to,@PathVariable  int period);
		
}
