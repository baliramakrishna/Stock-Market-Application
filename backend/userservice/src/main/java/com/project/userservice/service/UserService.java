package com.project.userservice.service;

import com.project.userservice.dto.UserDTO;
import com.project.userservice.model.UserEntity;

public interface UserService {
 
	UserDTO getUser(String userName,String password);
	UserDTO addUser(UserEntity userEntity);
	
}
