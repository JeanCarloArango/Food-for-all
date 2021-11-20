package com.hackaton.foodforall.dao;

import java.sql.PreparedStatement;
import com.hackaton.foodforall.dto.*;

public class DonorDAO {
	/**
	 * Defined variables globals
	 */
	private ConnectionDB conn;
	private PreparedStatement sentence;
	String sql;

	/**
	 * This method receives as a parameter an object of type 
	 * donation that brings the donor's data and the data of the 
	 * donated food, in this case only the donor's data will be saved.
	 */
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
			e.printStackTrace();
			return false;
		}
	}
	
}
