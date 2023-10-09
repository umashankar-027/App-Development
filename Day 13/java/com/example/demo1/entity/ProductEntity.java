package com.example.demo1.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity(name="tech_basket")
@Table(name="product")
public class ProductEntity 
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="pid")
	private int pid;
	
	@Column(name="name")
	private String name;

	@Column(name="price")
	private int price;
	
	@Column(name="likes")
	private int likes=0;
	
	@Column(name="dislike")
	private int dislike=0;
	
	@Column(name="seller_id")
	private int seller_id=0;
	
	@Column(name="category")
	private String category;

	@Column(columnDefinition = "text",name="image")
	private String img;
	
	public ProductEntity(int pid, String name, int price,int seller_id, String category,String img) 
	{
		super();
		this.pid = pid;
		this.name = name;
		this.price = price;
		this.seller_id = seller_id;
		this.category = category;
		this.img = img;
	}
	
	public ProductEntity() {
		super();
	}

	public int getPid() 
	{
		return pid;
	}

	public void setPid(int pid) 
	{
		this.pid = pid;
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public int getPrice() 
	{
		return price;
	}

	public void setPrice(int price) 
	{
		this.price = price;
	}

	public String getCategory() 
	{
		return category;
	}

	public void setCategory(String category) 
	{
		this.category = category;
	}

	public String getImg() 
	{
		return img;
	}

	public void setImg(String img) 
	{
		this.img = img;
	}
	
	@Override
	public String toString() 
	{
		return "ProductEntity [pid=" + pid + ", name=" + name + ", price=" + price + ", seller_id=" + seller_id + ", category=" + category + ", img=" + img + "]";
	}
	
}
