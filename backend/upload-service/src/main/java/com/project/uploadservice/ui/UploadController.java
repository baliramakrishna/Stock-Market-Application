package com.project.uploadservice.ui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.project.uploadservice.model.StockPriceEntity;
import com.project.uploadservice.service.UploadService;

@RestController
public class UploadController {
	
	@Autowired
	UploadService service;
	
	@PostMapping("/import")
	public List<StockPriceEntity> mapReapExcelDatatoDB(@RequestParam("file") MultipartFile reapExcelDataFile) throws IOException {
	    
	    List< StockPriceEntity> list = new ArrayList<>();
	    
	    XSSFWorkbook workbook = new XSSFWorkbook(reapExcelDataFile.getInputStream());
	    XSSFSheet worksheet = workbook.getSheetAt(0);
	    
	    for(int i=1;i<worksheet.getPhysicalNumberOfRows() ;i++) {
	        StockPriceEntity temp = new StockPriceEntity();
	            
	        XSSFRow row = worksheet.getRow(i);
	         
	        if(row==null)
	        	break;
	       
            temp.setCompanyId((long) row.getCell(0).getNumericCellValue());
	        temp.setStockExchange(row.getCell(1).getStringCellValue());
           temp.setCurrentPrice((double)row.getCell(2).getNumericCellValue());
           temp.setDate(row.getCell(3).getDateCellValue());
            temp.setTime(row.getCell(4).getStringCellValue());
            list.add(temp);
	        
	    }
	    return service.addStockPrice(list);
	}
	
	@GetMapping("/{company_id}/{from}/{ to}/{period}")
	public Iterable<Double> getCompanyStockPrice(@PathVariable Long company_id,@PathVariable  Date from,@PathVariable  Date to,@PathVariable  int period){
		
		return service.getCompanyStockPrice(company_id,from,to,period);
	}
}
