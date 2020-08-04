package com.project.uploadservice.service;

import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;

import com.project.uploadservice.model.StockPriceEntity;

public interface UploadService {
 
	List<StockPriceEntity> addStockPrice(List<StockPriceEntity> list);
	Iterable<Double> getCompanyStockPrice(Long company_id, Date fromDate, Date toDate,int periodicity);
}
