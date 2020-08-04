package com.project.stockexchange.ui;

import java.util.Date;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.companyservice.dto.CompanyDTO;

@FeignClient("company-service")
public interface CompanyEntity {
  
	
	@RequestMapping(value="stockExchange/{stockExchange}",  method=RequestMethod.GET,  produces=MediaType.APPLICATION_JSON_VALUE)
	public Iterable<CompanyDTO> getCompanyDetailsByStockExchange(@PathVariable String stockExchange);
	
}
