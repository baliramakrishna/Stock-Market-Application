package com.project.companyservice.ui;



import java.util.Date;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@FeignClient("upload-service")
public interface StockPriceEntity {
    
	@GetMapping("/{company_id}/{from}/{ to}/{period}")
	public Iterable<Double> getCompanyStockPrice(@PathVariable Long company_id,@PathVariable  Date from,@PathVariable  Date to,@PathVariable  int period);
		
}
