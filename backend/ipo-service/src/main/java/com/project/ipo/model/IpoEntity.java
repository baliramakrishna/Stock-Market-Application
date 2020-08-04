package com.project.ipo.model;

import java.util.Date;

import javax.persistence.Column;
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
@Table(name="IPO")
public class IpoEntity {
 	
    @Id
    @Column(name="company_id")
	private Long companyId;
    @Column(name="company_name")
	private String companyName ;
    @Column(name="share_price")
	private Double sharePrice;
    @Column(name="total_shares")
	private Integer totalShares;
    @Column(name="open_date")
	private Date openDate;
	private String remarks;
	
}
