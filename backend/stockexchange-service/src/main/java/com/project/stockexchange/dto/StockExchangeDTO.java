package com.project.stockexchange.dto;

import com.project.stockexchange.model.StockExchangeEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class StockExchangeDTO {
  
	private String stockExchange;
	private String brief;
	private String address;
	private String remarks;
}
