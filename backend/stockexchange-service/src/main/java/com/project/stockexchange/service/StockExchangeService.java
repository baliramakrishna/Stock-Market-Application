package com.project.stockexchange.service;

import com.project.companyservice.dto.CompanyDTO;
import com.project.stockexchange.dto.StockExchangeDTO;
import com.project.stockexchange.model.StockExchangeEntity;

public interface StockExchangeService {

	
	Iterable<StockExchangeDTO> getStockExchangesList();
	 void addStockExchange(StockExchangeEntity entity);
	 Iterable<CompanyDTO> getCompaniesList(String stockExchange);
}
