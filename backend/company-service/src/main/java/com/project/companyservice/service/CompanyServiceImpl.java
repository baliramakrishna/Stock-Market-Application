package com.project.companyservice.service;


import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.companyservice.dto.CompanyDTO;
import com.project.companyservice.dto.IpoDTO;
import com.project.companyservice.model.CompanyEntity;
import com.project.companyservice.repository.CompanyRepository;



@Service
public class CompanyServiceImpl implements CompanyService {
   
	@Autowired
	CompanyRepository repo;
	
	@Override
	public List<Double> getCompanyStockPrice(Long companyId, Date fromDate, Date toDate, int periodicity) {
		
	
    	
    	return null;
	}
	
	@Override
	public Iterable<CompanyDTO> getMatchingCompanies(String pattern) {
	    List<CompanyDTO> list = new ArrayList<>();
	    Iterable<CompanyEntity> companyEntity=repo.findByCompanyNameContaining(pattern);
	    ModelMapper mapper=new ModelMapper();
	    mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	    
	    for(CompanyEntity entity: companyEntity) {
	    	list.add(mapper.map(entity, CompanyDTO.class));
	    }
	    Iterable<CompanyDTO> dto=list;
		return dto;
	}



	@Override
	public CompanyDTO getCompanyDetails(String company_name) {
		
		CompanyEntity companyEntity=repo.findByCompanyName(company_name);
		 ModelMapper mapper=new ModelMapper();
		 mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		 return mapper.map(companyEntity, CompanyDTO.class);
		
	}

	@Override
	public Iterable<CompanyDTO> getCompanyDetailsBySector(String sector) {
		List<CompanyDTO> list = new ArrayList<>();
	    Iterable<CompanyEntity> companyEntity=repo.findBySector(sector);
	    ModelMapper mapper=new ModelMapper();
	    mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	    
	    for(CompanyEntity entity: companyEntity) {
	    	list.add(mapper.map(entity, CompanyDTO.class));
	    }
	    Iterable<CompanyDTO> dto=list;
	    return dto;
	}

	@Override
	public Iterable<Double> getSectorStockPrice(String sector_name, Date from, Date to, int period) {
		return null;
	}

	@Override
	public Iterable<CompanyDTO> getCompaniesByStockExchange(String stockExchange) {
		 List<CompanyDTO> list = new ArrayList<>();
		    Iterable<CompanyEntity> companyEntity=repo.findByStockExchange(stockExchange);
		    ModelMapper mapper=new ModelMapper();
		    mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		    
		    for(CompanyEntity entity: companyEntity) {
		    	list.add(mapper.map(entity, CompanyDTO.class));
		    }
		    Iterable<CompanyDTO> dto=list;
		    return dto;
	}

	@Override
	public CompanyDTO addCompany(CompanyEntity entity) {
		repo.save(entity);
		 ModelMapper mapper=new ModelMapper();
		 mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return mapper.map(entity,CompanyDTO.class);
	}

}
