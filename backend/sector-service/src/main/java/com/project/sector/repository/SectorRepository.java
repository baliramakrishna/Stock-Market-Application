package com.project.sector.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.sector.model.SectorEntity;

@Repository
public interface SectorRepository extends CrudRepository<SectorEntity,Long> {
   
	@Query(value = "SELECT sector FROM SECTOR WHERE sector_id = ?1", nativeQuery = true)
	  String getSector(Long sector_id);
	
}
