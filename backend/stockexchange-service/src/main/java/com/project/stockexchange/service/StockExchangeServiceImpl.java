package com.project.stockexchange.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.companyservice.dto.CompanyDTO;
import com.project.companyservice.model.CompanyEntity;
import com.project.stockexchange.dto.StockExchangeDTO;
import com.project.stockexchange.model.StockExchangeEntity;
import com.project.stockexchange.repository.StockExchangeRepository;

@Service
public class StockExchangeServiceImpl implements StockExchangeService {

	
	@Autowired
	StockExchangeRepository repo;
	
	@Override
	public Iterable<StockExchangeDTO> getStockExchangesList() {
		
		List<StockExchangeDTO> list = new ArrayList<>();
	    Iterable<StockExchangeEntity> companyEntity=repo.findAll();
	    ModelMapper mapper=new ModelMapper();
	    mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	    
	    for(StockExchangeEntity entity: companyEntity) {
	    	list.add(mapper.map(entity, StockExchangeDTO.class));
	    }
	    Iterable<StockExchangeDTO> dto=list;
		return dto;
	}

	@Override
	public void addStockExchange(StockExchangeEntity entity) {
		repo.save(entity);
	}

	@Override
	public Iterable<CompanyDTO> getCompaniesList(String stockExchange) {
		return null;
	}

}
