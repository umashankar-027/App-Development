package com.example.demo1.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo1.entity.UserEntity;
import com.example.demo1.entity.Userjwt;
import com.example.demo1.repository.UserRepo;

@Service
public class UserService implements UserServiceInt
{
	@Autowired
	private UserRepo ur;

	@Override
	public void addNewUser(UserEntity ue) 
	{
		ur.save(ue);
	}
	@Override
	public boolean authLogin(Userjwt user) {
		Optional<UserEntity> userOpt = ur.findByName(user.getUserName());
		
		if (!userOpt.isPresent()) return false;
		if (!user.getPassword().equals(userOpt.get().getPassword())) return false;

		return true;
	}
}
