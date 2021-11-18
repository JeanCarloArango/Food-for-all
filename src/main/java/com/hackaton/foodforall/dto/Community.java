package com.hackaton.foodforall.dto;

public class Community {

	private String id;
	private String communityName;
	private int status;

	public Community(String id, String communityName, int status) {
		super();
		this.id = id;
		this.communityName = communityName;
		this.status = status;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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