package com.project.ipo.repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.ipo.model.IpoEntity;


@Repository
public interface IpoRepository extends CrudRepository<IpoEntity,Long> {
  
	  IpoEntity findByCompanyName(String company_name);
	
}
