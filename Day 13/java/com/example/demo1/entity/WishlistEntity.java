package com.example.demo1.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="wishlist")
public class WishlistEntity 
{
	@Id
	@Column(name="user_id")
	private int user_id;
	
	@Column(name="pid")
	private int pid;

	public WishlistEntity(int user_id, int pid)
	{
		super();
		this.user_id = user_id;
		this.pid = pid;
	}

	public int getUser_id()
	{
		return user_id;
	}

	public void setUser_id(int user_id) 
	{
		this.user_id = user_id;
	}

	public int getPid() 
	{
		return pid;
	}

	public void setPid(int pid) 
	{
		this.pid = pid;
	}
	
	
}
