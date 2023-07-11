package com.SportyShoes.model;



public class TransactionDTO {

private int tran_id;
	
    private int user_id;
	private String email;
	private String category;
	private String product_name;
	private String appointmentTime;
	
	public TransactionDTO(int tran_id, int user_id, String email, String category, String product_name,
			String appointmentTime) {
		super();
		this.tran_id = tran_id;
		this.user_id = user_id;
		this.email = email;
		this.category = category;
		this.product_name = product_name;
		this.appointmentTime = appointmentTime;
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
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getAppointmentTime() {
		return appointmentTime;
	}
	public void setAppointmentTime(String appointmentTime) {
		this.appointmentTime = appointmentTime;
	}
	
	
	
}
