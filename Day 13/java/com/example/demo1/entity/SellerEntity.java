package com.example.demo1.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="seller")
public class SellerEntity 
{
	@Id
	@Column(name="seller_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int seller_id;
	
	@Column(name="user_id")
	private int user_id;
	
	@Column(name="country")
	private String country;

	public SellerEntity(int seller_id, int user_id, String country) 
	{
		super();
		this.seller_id = seller_id;
		this.user_id = user_id;
		this.country = country;
	}

	public int getSeller_id()
	{
		return seller_id;
	}

	public void setSeller_id(int seller_id) 
	{
		this.seller_id = seller_id;
	}

	public int getUser_id() 
	{
		return user_id;
	}

	public void setUser_id(int user_id) 
	{
		this.user_id = user_id;
	}

	public String getCountry() 
	{
		return country;
	}

	public void setCountry(String country) 
	{
		this.country = country;
	}
	
}
