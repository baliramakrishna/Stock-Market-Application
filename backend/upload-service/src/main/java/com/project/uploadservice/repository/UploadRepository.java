package com.project.uploadservice.repository;



import java.util.Date;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.uploadservice.model.StockPriceEntity;


@Repository
public interface UploadRepository extends CrudRepository<StockPriceEntity, Long> {

	@Query(value="select currentPrice from Stock where companyId=?1 and date between ?2 and ?3 order by date desc,time desc;",nativeQuery=true)
	Double findByIdAndDateBetweenAndStockExchange(Long companyId, Date fromDate, Date toDate);
}
