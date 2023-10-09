package com.example.demo1.service;

import java.util.List;
import java.util.Optional;

import com.example.demo1.entity.ProductEntity;

public interface ProductServiceInt 
{
	public List<ProductEntity>getAll();
	
	public Optional<ProductEntity>getByPid(int pid);
	
	public Optional<ProductEntity>getByName(String name);
	
	public List<ProductEntity>getByCategory(String category);
	
	public List<ProductEntity>getByPriceG(int price);
	
	public void addProduct(ProductEntity pe);
	
	public void updateByPid(ProductEntity me);
	
	public void deleteByName(String name);
	
	public void deleteByCategory(String category);
	
	public List<ProductEntity>getTopSelling();

	public List<ProductEntity>getNewArrivals();
	
	public List<ProductEntity>getCartItems(int user_id);
	
}
