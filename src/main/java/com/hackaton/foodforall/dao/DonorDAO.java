package com.hackaton.foodforall.dao;

import java.sql.PreparedStatement;
import com.hackaton.foodforall.dto.*;

public class DonorDAO {
	private ConnectionDB conn;
	private PreparedStatement sentence;
	String sql;

	public Boolean createDonationF(Donation don) {
		conn = new ConnectionDB();
		try {
			sql = "INSERT INTO DONOR (NAME, EMAIL, PHONE,"
					+ " TIPO, COMMUNITY_ID) VALUES (?,?,?,?,?);";
			sentence = this.conn.pStm(sql);
			sentence.setString(1, don.getNameD());
			sentence.setString(2, don.getEmailD());
			sentence.setString(3, don.getPhoneD());
			sentence.setString(4, don.getTypeD());
			sentence.setInt(5, don.getCommunityD());
			
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
