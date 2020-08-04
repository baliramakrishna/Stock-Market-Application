package com.project.userservice.dto;

import javax.persistence.Column;

import com.project.userservice.model.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO {
 
	    private String userName;
	    private String password;
	    private String userType;
	    private String email;
	    private long mobileNumber;
	    private boolean confirmed;
}
