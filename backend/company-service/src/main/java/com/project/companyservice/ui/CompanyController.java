package com.project.companyservice.ui;
import java.util.Date;

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
import com.project.companyservice.dto.IpoDTO;
import com.project.companyservice.model.CompanyEntity;
import com.project.companyservice.service.CompanyService;


@RestController
public class CompanyController {
    
	private CompanyService service;
	private StockPriceEntity stockPriceEntity;
	private IpoEntity ipoEntity;
	
	public CompanyController(CompanyService service, StockPriceEntity  stockPriceEntity, IpoEntity ipoEntity) {
		super();
		this.service = service;
		this. stockPriceEntity =  stockPriceEntity;
		this.ipoEntity = ipoEntity;
	}
   
	
	
	@RequestMapping(value="/",  method=RequestMethod.POST,  produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CompanyDTO> addCompany(@RequestBody CompanyEntity entity) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.addCompany(entity));
	}

	@HystrixCommand(fallbackMethod= "defaultResponse")
	@RequestMapping(value="/company_stock_price/{company_id}/{from}/{ to}/{period}",  method=RequestMethod.GET,  produces=MediaType.APPLICATION_JSON_VALUE)
	public  ResponseEntity<Iterable<Double>> getCompanyStockPrice(@PathVariable Long company_id,@PathVariable  Date from,@PathVariable  Date to,@PathVariable  int period) {
		return ResponseEntity.status(HttpStatus.OK).body( stockPriceEntity.getCompanyStockPrice(company_id, from, to, period));
	}

	@RequestMapping(value="/matching_companies/{pattern}",  method=RequestMethod.GET,  produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Iterable<CompanyDTO>> getMatchingCompanies(@PathVariable String pattern) {
		return ResponseEntity.status(HttpStatus.OK).body(service.getMatchingCompanies(pattern));
	}
	
	@RequestMapping(value="/company_details/{company_name}",  method=RequestMethod.GET,  produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CompanyDTO> getCompanyDetails(@PathVariable String company_name) {
		return ResponseEntity.status(HttpStatus.OK).body(service.getCompanyDetails(company_name));
	}
   
	@HystrixCommand(fallbackMethod= "defaultResponse")
	@RequestMapping(value="/company_ipo_details/{company_name}",  method=RequestMethod.GET,  produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<IpoDTO> getCompanyIPODetails(@PathVariable String company_name) {
		return ipoEntity.getCompanyIPODetails(company_name);
	}
	
	@RequestMapping(value="sector/{sector}",  method=RequestMethod.GET,  produces=MediaType.APPLICATION_JSON_VALUE)
	public Iterable<CompanyDTO> getCompanyDetailsBySector(@PathVariable String sector){
		return service.getCompanyDetailsBySector(sector);
	}
	
	@RequestMapping(value="{sector_name}/{from}/{ to}/{period}",  method=RequestMethod.GET,  produces=MediaType.APPLICATION_JSON_VALUE)
	public  ResponseEntity<Iterable<Double>> getSectorPrice(String sector_name, Date from,@PathVariable  Date to,@PathVariable  int period) {
		
		
		return ResponseEntity.status(HttpStatus.OK).body(service.getSectorStockPrice(sector_name, from, to, period));

		
	}
	
	@RequestMapping(value="stockExchange/{stockExchange}",  method=RequestMethod.GET,  produces=MediaType.APPLICATION_JSON_VALUE)
	public Iterable<CompanyDTO> getCompanyDetailsByStockExchange(@PathVariable String stockExchange){
		return service.getCompaniesByStockExchange(stockExchange);
	}
	
	// When we define a fallback-method, the fallback-method must match the same parameters of the method where you define the Hystrix Command using the hystrix-command annotation.
	public ResponseEntity<String> defaultResponse(String err) {
		System.out.println("You are seeing this fallback response because the underlying microservice is down.");
		err = "Fallback error as the microservice is down.";
		return new ResponseEntity<>(err, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
