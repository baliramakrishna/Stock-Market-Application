package com.project.uploadservice.service;

import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.uploadservice.model.StockPriceEntity;
import com.project.uploadservice.repository.UploadRepository;



@Service
public class UploadServiceImpl implements UploadService {

	
	@Autowired
	 UploadRepository repo;
	
	@Override
	public List<StockPriceEntity> addStockPrice(List<StockPriceEntity> list) {
		
		for(StockPriceEntity entity:list)
			repo.save(entity);
		
		return list;
			
	}

	@Override
	public Iterable<Double> getCompanyStockPrice(Long companyId, Date fromDate, Date toDate, int periodicity) {
		
		long Duration=toDate.getTime()-fromDate.getTime();
    	int days=(int) (TimeUnit.MILLISECONDS.toDays(Duration)+1);
    	List< Double >list=new ArrayList<>();
    	Date dt=fromDate;
    	Date dt1=fromDate;
    	int inc=days/periodicity;
    	int mod=days%periodicity;
    	for(int i=0;i<inc;i++)
    	{  
    	fromDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    		dt1=addDays(dt,periodicity-1);
    		list.add(repo.findByIdAndDateBetweenAndStockExchange(companyId, fromDate, toDate));
    		dt=addDays(dt1,1);
    		
    	}
    	if(mod!=0)
    		list.add(repo.findByIdAndDateBetweenAndStockExchange(companyId,dt,dt1));
		return list;
	}
	
	public static Date addDays(Date date,int days)
    {
    	Calendar c=Calendar.getInstance();
		 c.setTime(date);
		 c.add(Calendar.DATE,days);
		 return new Date(c.getTimeInMillis());
    }

}
