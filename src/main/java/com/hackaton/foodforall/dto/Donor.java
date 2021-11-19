package com.hackaton.foodforall.dto;

public class Donor {

	private String name;
	private String email;
	private String phone;
	private String community;
	private String type;

	public Donor(String name, String email, String phone, String community, String type) {
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.community = community;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCommunity() {
		return community;
	}

	public void setCommunity(String community) {
		this.community = community;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}


}
