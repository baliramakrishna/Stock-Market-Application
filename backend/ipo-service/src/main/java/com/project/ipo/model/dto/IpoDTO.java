package com.project.ipo.model.dto;

import java.util.Date;

import javax.persistence.Column;

import com.project.ipo.model.IpoEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class IpoDTO {
  
		private String companyName ;
		private Double sharePrice;
		private Integer totalShares;
		private Date openDate;
		private String remarks;
}
