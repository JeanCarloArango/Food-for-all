package com.hackaton.foodforall.dao;

import java.sql.PreparedStatement;

public class BeneficiariesDAO {
	private ConnectionDB conn;
	private PreparedStatement sentence;
	String sql;
	
	public Boolean createBeneficiaries() {
		conn = new ConnectionDB();
		try {
			//insert into foodforall.community (name) values ("Sumapaz");
			sql = "INSERT INTO CHILDEN (DNI, NAME, AGE, STRATUS, EMAIL, PHONE,"
					+ " COMMUNITY_ID) VALUES (?,?,?,?,?,?,?);";
			
			Boolean res = false;
			if (!sentence.execute()) {
				res = true;
			}
			return res;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
}
