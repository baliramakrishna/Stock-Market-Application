package com.project.userservice.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.userservice.model.UserEntity;

@Repository
public interface UserRepository extends CrudRepository<UserEntity,Long> {
   
	
	@Query(value = "SELECT * FROM USER WHERE username=?1 AND password=?2", 
			  nativeQuery = true)
	UserEntity getUser(String userName,String password );		
}
