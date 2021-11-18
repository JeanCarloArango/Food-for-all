package com.hackaton.foodforall.dto;

public class Donor {

	enum Edonor {
		person, organization
	}

	private String name;
	private String email;
	private String phone;
	private String community;
	Edonor type;

	public Donor(String name, String email, String phone, String community, Edonor type) {
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

	public Edonor getTipo() {
		return type;
	}

	public void setTipo(Edonor tipo) {
		this.type = tipo;
	}

}
