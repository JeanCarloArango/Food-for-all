package com.hackaton.foodforall.dto;

public class Community {

	private int communityId;
	private String communityName;

	public Community(int communityId, String communityName) {
		super();
		this.communityId = communityId;
		this.communityName = communityName;
	}
	
	public int getCommunityId() {
		return communityId;
	}

	public String getCommunityName() {
		return communityName;
	}
	
}