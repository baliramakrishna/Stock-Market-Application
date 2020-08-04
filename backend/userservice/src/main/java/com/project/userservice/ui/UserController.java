package com.project.userservice.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.userservice.dto.UserDTO;
import com.project.userservice.model.UserEntity;
import com.project.userservice.service.UserService;

@RestController
public class UserController {

	
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/user/{userName}/{password}",method = RequestMethod.GET)
	public UserDTO getUser(@PathVariable String userName,@PathVariable String password) throws Exception
	{
		return userService.getUser(userName, password);
	}
	@RequestMapping(value="/user/",method = RequestMethod.POST)
    public UserDTO createUser(@RequestBody UserEntity userEntity)
    {

        return userService.addUser(userEntity);
    }
	
}
