package com.hackaton.foodforall.dto;

public class Donor {

	private String name;
	private String email;
	private String phone;
	private String type;
	private int community;
	
	public Donor(String name, String email, String phone, String type, int community) {
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.type = type;
		this.community = community;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPhone() {
		return phone;
	}

	public String getType() {
		return type;
	}

	public int getCommunity() {
		return community;
	}
}
