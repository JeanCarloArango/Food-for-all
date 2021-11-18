package com.hackaton.foodforall.dto;

public class Feed {

	private String name;
	private String type;
	private String count;
	private String status;
	private String donor;

	public Feed(String name, String type, String count, String status, String donor) {
		super();
		this.name = name;
		this.type = type;
		this.count = count;
		this.status = status;
		this.donor = donor;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDonor() {
		return donor;
	}

	public void setDonor(String donor) {
		this.donor = donor;
	}

}
