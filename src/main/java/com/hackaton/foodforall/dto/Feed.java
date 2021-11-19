package com.hackaton.foodforall.dto;

public class Feed {

	private String name;
	private String type;
	private String count;
	private String status;
	private int donor;

	public Feed(String name, String type, String count, String status, int donor) {
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

	public String getType() {
		return type;
	}

	public String getCount() {
		return count;
	}

	public String getStatus() {
		return status;
	}

	public int getDonor() {
		return donor;
	}

}
