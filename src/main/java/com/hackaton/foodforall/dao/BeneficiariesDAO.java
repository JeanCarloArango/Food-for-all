package com.hackaton.foodforall.dao;

import java.sql.PreparedStatement;

import com.hackaton.foodforall.dto.Beneficiaries;

public class BeneficiariesDAO {
	private ConnectionDB conn;
	private PreparedStatement sentence;
	String sql;
	
	public Boolean createBeneficiaries(Beneficiaries ben) {
		conn = new ConnectionDB();
		try {
			sql = "INSERT INTO BENEFICIARIES (DNI, NAME, AGE, STATUS, EMAIL, PHONE,"
					+ " COMMUNITY_ID) VALUES (?,?,?,?,?,?,?);";
			sentence = this.conn.pStm(sql);
			sentence.setString(1, ben.getIdentify());
			sentence.setString(2, ben.getName());
			sentence.setInt(3, ben.getAge());
			sentence.setInt(4, ben.getStrat());
			sentence.setString(5, ben.getEmail());
			sentence.setString(6, ben.getPhone());
			sentence.setInt(7, ben.getCommunity());
			
			Boolean res = false;
			if (!sentence.execute()) {
				res = true;
			}
			conn.disconnect();
			sentence.close();
			return res;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}
}
