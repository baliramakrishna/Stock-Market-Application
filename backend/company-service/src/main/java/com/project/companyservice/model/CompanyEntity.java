package com.project.companyservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="COMPANY")
public class CompanyEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="company_id")
	private Long companyId;
	
	@Column(name="company_name")
	private String companyName;
	
	private Double turnover;
	private String ceo;
	private String directors;
	
	@Column(name="stock_exchange")
	private String  stockExchange;

	private String sector;
	
	private String brief;
	
	@Column(name="stock_code")
	private Long stockCode;
	
}
