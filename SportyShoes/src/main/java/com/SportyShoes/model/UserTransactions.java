package com.SportyShoes.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "transactions")
public class UserTransactions {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int tran_id;
	
	int user_id;
	String email;
	String category_name;
	String product_name;
	private LocalDateTime appointmentTime;
	
	public UserTransactions(int tran_id, int user_id, String email, String category_name, String product_name,
			LocalDateTime appointmentTime) {
		super();
		this.tran_id = tran_id;
		this.user_id = user_id;
		this.email = email;
		this.category_name = category_name;
		this.product_name = product_name;
		this.appointmentTime = appointmentTime;
	}
	
	

	public UserTransactions() {
		super();
		// TODO Auto-generated constructor stub
	}



	public int getTran_id() {
		return tran_id;
	}

	public void setTran_id(int tran_id) {
		this.tran_id = tran_id;
	}

	public int getUser_id() {
		return user_id;
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

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public LocalDateTime getAppointmentTime() {
		return appointmentTime;
	}

	public void setAppointmentTime(LocalDateTime appointmentTime) {
		this.appointmentTime = appointmentTime;
	}
	
	
	
	
	

}
