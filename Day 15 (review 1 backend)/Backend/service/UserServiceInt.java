package com.example.demo1.service;

import org.springframework.http.ResponseEntity;

import com.example.demo1.entity.UserEntity;
import com.example.demo1.entity.Userjwt;

public interface UserServiceInt
{	
	public void addNewUser(UserEntity ue);
	public boolean authLogin(Userjwt user);
	
}
