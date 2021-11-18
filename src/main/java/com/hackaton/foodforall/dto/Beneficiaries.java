package com.hackaton.foodforall.dto;

public class Beneficiaries {

	private String identify;
	private String name;
	private String age;
	private String email;
	private String phone;
	private int strat;

	public Beneficiaries(String identify, String name, String age, String email, String phone, int strat) {
		super();
		this.identify = identify;
		this.name = name;
		this.age = age;
		this.email = email;
		this.phone = phone;
		this.strat = strat;
	}

	public String getId() {
		return identify;
	}

	public void setId(String id) {
		this.identify = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
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

	public int getCommunity() {
		return strat;
	}

	public void setCommunity(int strat) {
		this.strat = strat;
	}

}
