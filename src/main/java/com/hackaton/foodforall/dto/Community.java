package com.hackaton.foodforall.dto;

public class Community {

	private String communityName;
	private int status;

	public Community(String communityName, int status) {
		super();
		this.communityName = communityName;
		this.status = status;
	}

	public String getCommunityName() {
		return communityName;
	}

	public void setCommunityName(String communityName) {
		this.communityName = communityName;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}