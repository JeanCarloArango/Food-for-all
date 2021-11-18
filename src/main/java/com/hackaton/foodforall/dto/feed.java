package com.hackaton.foodforall.dto;

public class feed {

	private String id;
	private String name;
	private String type;
	private String count;
	private String status;
	private String donor;

	public feed(String id, String name, String type, String count, String status, String donor) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.count = count;
		this.status = status;
		this.donor = donor;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
