package com.example.demo1.entity;

public class Userjwt 
{
	String userName;
	String password;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return this.password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Userjwt(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	
	public Userjwt(){}
	@Override
	public String toString() {
		return "Userjwt [userName=" + this.userName + ", Password=" + this.password + "]";
	}
	
}
