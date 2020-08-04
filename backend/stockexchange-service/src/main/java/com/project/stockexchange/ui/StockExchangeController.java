package com.project.stockexchange.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.project.companyservice.dto.CompanyDTO;
import com.project.stockexchange.dto.StockExchangeDTO;
import com.project.stockexchange.model.StockExchangeEntity;
import com.project.stockexchange.service.StockExchangeService;

@RestController
public class StockExchangeController {
    

	private StockExchangeService service;
	private CompanyEntity entity;
	
	public StockExchangeController(StockExchangeService service, CompanyEntity entity) {
		super();
		this.service = service;
		this.entity = entity;
	}
	@HystrixCommand(fallbackMethod= "defaultResponse")
	@RequestMapping(value="/{stockExchange}",  method=RequestMethod.GET,  produces=MediaType.APPLICATION_JSON_VALUE)
	public Iterable<CompanyDTO> getCompanyDetailsByStockExchange(@PathVariable String stockExchange){
		return entity.getCompanyDetailsByStockExchange(stockExchange);
	}
	
	@RequestMapping(value="/{stockExchange}",  method=RequestMethod.POST,  produces=MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
	public void saveStockExchange(@RequestBody StockExchangeEntity entity) {
		service.addStockExchange(entity);
	}
	
	@RequestMapping(value="/stockExchangeDetails",  method=RequestMethod.GET,  produces=MediaType.APPLICATION_JSON_VALUE)
	public Iterable<StockExchangeDTO> getStockExchangesList(){
		return service.getStockExchangesList();
	}
	
	
	// When we define a fallback-method, the fallback-method must match the same parameters of the method where you define the Hystrix Command using the hystrix-command annotation.
	public ResponseEntity<String> defaultResponse(String err) {
		System.out.println("You are seeing this fallback response because the underlying microservice is down.");
		err = "Fallback error as the microservice is down.";
		return new ResponseEntity<>(err, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	
	
}
