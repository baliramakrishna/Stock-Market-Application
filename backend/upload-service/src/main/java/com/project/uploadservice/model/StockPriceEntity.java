package com.project.uploadservice.model;



import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="Stock")
public class StockPriceEntity {
   
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private Long companyId;
	private String stockExchange;
	private Double currentPrice;
    private Date date;
    private String time;
}
