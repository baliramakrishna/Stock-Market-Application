package com.project.companyservice.service;


import java.util.Date;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.companyservice.dto.CompanyDTO;
import com.project.companyservice.dto.IpoDTO;
import com.project.companyservice.model.CompanyEntity;


@Service
public interface CompanyService {
 
	Iterable<Double> getCompanyStockPrice(Long company_id,Date from,Date to,int period);
	Iterable<CompanyDTO> getMatchingCompanies(String pattern);
	CompanyDTO getCompanyDetails(String company_name);
	Iterable<CompanyDTO> getCompanyDetailsBySector(String sector);
	Iterable<Double> getSectorStockPrice(String sector_name,Date from,Date to,int period);
	Iterable<CompanyDTO> getCompaniesByStockExchange(String stockExchange);
	  CompanyDTO addCompany(CompanyEntity entity);
}
