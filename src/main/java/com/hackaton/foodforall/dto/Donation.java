package com.hackaton.foodforall.dto;

public class Donation {
	
	private String nameD;
	private String emailD;
	private String phoneD;
	private String typeD;
	private int communityD;
	private String nameF;
	private String typeF;
	private String countF;
	private String statusF;
	
	public Donation(String nameD, String emailD, String phoneD, String typeD, int communityD, String nameF,
			String typeF, String countF, String statusF) {
		super();
		this.nameD = nameD;
		this.emailD = emailD;
		this.phoneD = phoneD;
		this.typeD = typeD;
		this.communityD = communityD;
		this.nameF = nameF;
		this.typeF = typeF;
		this.countF = countF;
		this.statusF = statusF;
	}
	public String getNameD() {
		return nameD;
	}
	public String getEmailD() {
		return emailD;
	}
	public String getPhoneD() {
		return phoneD;
	}
	
	public String getTypeD() {
		return typeD;
	}
	
	public int getCommunityD() {
		return communityD;
	}
	
	public String getNameF() {
		return nameF;
	}
	
	public String getTypeF() {
		return typeF;
	}
	
	public String getCountF() {
		return countF;
	}
	
	public String getStatusF() {
		return statusF;
	}
}
