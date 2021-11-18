package com.hackaton.foodforall.dto;

public class Beneficiaries {

	private String identify;
	private String name;
	private int age;
	private int strat;
	private String email;
	private String phone;
	private int community;
	
	public Beneficiaries(String identify, String name, int age, int strat, 
			String email, String phone, int community) {
		super();
		this.identify = identify;
		this.name = name;
		this.age = age;
		this.strat = strat;
		this.email = email;
		this.phone = phone;
		this.community = community;
	}

	public String getIdentify() {
		return identify;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public int getStrat() {
		return strat;
	}

	public String getEmail() {
		return email;
	}

	public String getPhone() {
		return phone;
	}

	public int getCommunity() {
		return community;
	}
}
