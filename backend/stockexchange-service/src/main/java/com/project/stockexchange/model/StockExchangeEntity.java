package com.project.stockexchange.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="STOCKEXCHANGE")
public class StockExchangeEntity {
   
	@Id
	private Long id;
	private String stockExchange;
	private String brief;
	private String address;
	private String remarks;
}
