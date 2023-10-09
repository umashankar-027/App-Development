package com.example.demo1.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="order")
public class OrderEntity 
{
	@Id
	@Column(name="pid")
	private int pid;
	
	@Column(name="seller_id")
	private int seller_id;
	
	@Column(name="status")
	private int status;

	public OrderEntity(int pid, int seller_id, int status) 
	{
		super();
		this.pid = pid;
		this.seller_id = seller_id;
		this.status = status;
	}

	public int getPid()
	{
		return pid;
	}

	public void setPid(int pid) 
	{
		this.pid = pid;
	}

	public int getSeller_id() 
	{
		return seller_id;
	}

	public void setSeller_id(int seller_id) 
	{
		this.seller_id = seller_id;
	}

	public int getStatus() 
	{
		return status;
	}

	public void setStatus(int status) 
	{
		this.status = status;
	}
	
}
