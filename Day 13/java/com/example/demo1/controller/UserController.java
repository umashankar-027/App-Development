package com.example.demo1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo1.entity.UserEntity;
import com.example.demo1.entity.Userjwt;
import com.example.demo1.service.UserService;
import com.example.demo1.util.Jwtutil;

@RestController
public class UserController 
{
	@Autowired
	private UserService us;
	
	@GetMapping("/y")
	public String print()
	{
		return "Perfsavfect";
	}
	
	@PostMapping("/addNewUser")
	public void addNewUser(@RequestBody UserEntity ue)
	{
		us.addNewUser(ue);
	}
	
	@PostMapping("/login")
	public ResponseEntity<Boolean> l(@RequestBody Userjwt u)
	{

		if(us.authLogin(u))
		{	
			Jwtutil tokenize = new Jwtutil();
//			System.out.println(tokenize.verify("eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJzcmk7c3JpMzIxQCMiLCJpYXQiOjE2OTY0MTM4MzB9.WSdzxn51wFeP07ma7-1q4h6XNnUi22SEEzn05sTV1Yk");
			HttpHeaders responseHeaders = new HttpHeaders();
			
			responseHeaders.set("set-cookie" , ("session-id:"+tokenize.generateToken(u)+";HttpOnly"));
			return ResponseEntity.ok().headers(responseHeaders).body(true);
		}
		
		return ResponseEntity.ok().body(false);
		
	}
	
}
