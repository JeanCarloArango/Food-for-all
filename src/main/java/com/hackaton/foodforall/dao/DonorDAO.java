package com.hackaton.foodforall.dao;

import java.sql.PreparedStatement;
import com.hackaton.foodforall.dto.Donor;

public class DonorDAO {
	private ConnectionDB conn;
	private PreparedStatement sentence;
	String sql;
	
	public Boolean createDonor(Donor don) {
		conn = new ConnectionDB();
		try {
			sql = "INSERT INTO DONOR (NAME, EMAIL, PHONE,"
					+ " TIPO, COMMUNITY_ID) VALUES (?,?,?,?,?);";
			sentence = this.conn.pStm(sql);
			sentence.setString(1, don.getName());
			sentence.setString(2, don.getEmail());
			sentence.setString(3, don.getPhone());
			sentence.setString(4, don.getType());
			sentence.setInt(5, don.getCommunity());
			
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
