package com.example.demo1.controller;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo1.entity.PcategoryEntity;
import com.example.demo1.entity.PidEntity;
import com.example.demo1.entity.PnameEntity;
import com.example.demo1.entity.ProductEntity;
import com.example.demo1.entity.Puser_idEntity;
import com.example.demo1.service.ProductService;
import java.util.*;
@RestController
@CrossOrigin("*")
public class ProductController 
{
	@Autowired
	private ProductService ms;
	
	@GetMapping("/x")
	public ResponseEntity<String> print()
	{
		HttpHeaders responseHeaders = new HttpHeaders();
		
		responseHeaders.set("set-cookie" , "sessionId=e8bb43229de9;");
		
		return ResponseEntity.ok().headers(responseHeaders).body("Perfect");
//		return "Perfect";
	}
	
	@GetMapping("/getAll")
	public List<ProductEntity>getAll()
	{
		return ms.getAll();
	}
	
	@PostMapping("/getByPid")
	public Optional<ProductEntity> getByPid(@RequestBody PidEntity id)
	{
//		System.out.print(id.getPid());
		return ms.getByPid(id.getPid());
	} 
	
	@PostMapping("/getByName")
	public Optional<ProductEntity>getByName(@RequestBody PnameEntity name)
	{
//		System.out.print(name);
		return ms.getByName(name.getName());	
	}
	
	@PostMapping("/getByCategory")
	public List<ProductEntity>getByCategory(@RequestBody PcategoryEntity category)
	{
		return ms.getByCategory(category.getCategory());
	}
	
	@GetMapping("/getByPriceG")
	public List<ProductEntity>getByPriceG(@RequestParam int price)
	{
		return ms.getByPriceG(price);
	}
	
	@GetMapping("/getTopSelling")
	public List<ProductEntity>getTopSelling()
	{
		return ms.getTopSelling();
	}
	
	@GetMapping("/getNewArrivals")
	public List<ProductEntity>getNewArrivals()
	{
		return ms.getNewArrivals();
	}
	
	@PostMapping("/addProduct")
	public void addProduct(@RequestBody ProductEntity pe)
	{
//		pe.se
		ms.addProduct(pe);
	}
	
	@RequestMapping({"/updateByPid"})
    public void updateData(@RequestBody ProductEntity pe,@RequestParam int pid)
	{
    	pe.setPid(pid);
    	ms.updateByPid(pe);
	}
	
	@DeleteMapping("/deleteByName")
	public void deleteByName(@RequestBody PnameEntity pe)
	{
//		System.out.print(0);
		ms.deleteByName(pe.getName());
	}
	
	@DeleteMapping("/deleteByCategory")
	public void deleteByCategory(@RequestBody PcategoryEntity pe)
	{
		ms.deleteByCategory(pe.getCategory());
	}
	
	@GetMapping("/getCartItems")
	public List<ProductEntity> getCartItems(@RequestBody Puser_idEntity pe)
	{
		return ms.getCartItems(pe.getUser_id());
	}
	
}
