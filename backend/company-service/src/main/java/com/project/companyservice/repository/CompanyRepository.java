package com.project.companyservice.repository;


import java.sql.Date;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.project.companyservice.model.CompanyEntity;



@Repository
public interface CompanyRepository extends CrudRepository<CompanyEntity,Long> {
   
	Iterable<CompanyEntity> findByCompanyNameContaining(String pattern);
	CompanyEntity findByCompanyName(String company_name);
	Iterable<CompanyEntity> findBySector(String sector);
	Iterable<CompanyEntity> findByStockExchange(String stockExchange);
	
	 
	
}
