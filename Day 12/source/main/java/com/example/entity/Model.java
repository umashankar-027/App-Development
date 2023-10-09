package com.example.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Model {
	private String userName;
	private int userId;
	private String email;
	private String password;
	private String phoneNo;
	
	public Model(String userName, int userId, String email, String password, String phoneNo) {
		super();
		this.userName = userName;
		this.userId = userId;
		this.email = email;
		this.password = password;
		this.phoneNo = phoneNo;
	}

	public Model() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
