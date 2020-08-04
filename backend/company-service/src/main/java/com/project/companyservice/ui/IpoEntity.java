package com.project.companyservice.ui;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.project.companyservice.dto.IpoDTO;




@FeignClient("ipo-service")
public interface IpoEntity {
      
	@GetMapping("/{company_name}")
	public ResponseEntity<IpoDTO> getCompanyIPODetails(@PathVariable String company_name);
	
}
