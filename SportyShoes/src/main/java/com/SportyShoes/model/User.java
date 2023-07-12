package com.SportyShoes.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int user_id;
	
	private String email;
	private String password;
	private String token;
	
	
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public int getUser_id() {
		return user_id;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User(int user_id, String email, String password, String token) {
		super();
		this.user_id = user_id;
		this.email = email;
		this.password = password;
		this.token = token;
	}

	
	
	
}
