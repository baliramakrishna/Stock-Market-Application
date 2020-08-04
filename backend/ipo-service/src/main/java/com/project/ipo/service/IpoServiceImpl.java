package com.project.ipo.service;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.ipo.model.IpoEntity;
import com.project.ipo.model.dto.IpoDTO;
import com.project.ipo.repository.IpoRepository;


@Service
public class IpoServiceImpl implements IpoService {
    
	@Autowired
	IpoRepository repo;
	
	@Override
	public IpoDTO getCompanyIPODetails(String company_name) {
		
		IpoEntity ipoEntity=repo.findByCompanyName(company_name);
		System.out.println(ipoEntity);
		 ModelMapper mapper=new ModelMapper();
		 mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		 return mapper.map(ipoEntity,IpoDTO.class);
	}

}
