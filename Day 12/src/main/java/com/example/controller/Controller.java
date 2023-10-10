package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.repository.Repository;
import com.example.service.Service;

import ch.qos.logback.core.model.Model;

@RestController
@CrossOrigin("*")

public class Controller {
	@Autowired
	Repository obr;
	
	@GetMapping("/get")
	public List<Model> getDetails()
	{
		return obr.findAll();
	}
	
	@GetMapping("/getById/{id}")
	public L
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable int id)
	{
		obr.deleteById();
	}
	
	
}
