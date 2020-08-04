package com.project.userservice.service;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.userservice.dto.UserDTO;
import com.project.userservice.model.UserEntity;
import com.project.userservice.repository.UserRepository;


@Service
public class UserServiceImpl implements UserService {
  
	@Autowired
	UserRepository repo;
	@Override
	public UserDTO getUser(String userName, String password) {
		ModelMapper mapper=new ModelMapper();
		 mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return mapper.map(repo.getUser(userName, password),UserDTO.class);
		 
	}

	@Override
	public UserDTO addUser(UserEntity userEntity) {
		ModelMapper mapper=new ModelMapper();
		 mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		repo.save(userEntity);
		return mapper.map(userEntity,UserDTO.class);
	}

}
