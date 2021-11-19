package com.hackaton.foodforall.dao;

import java.sql.*;
import java.util.ArrayList;
import com.hackaton.foodforall.dto.Community;

public class CommunityDAO {
	private ConnectionDB conn;
	private PreparedStatement sentence;
	private String sql;
	
	public ArrayList<Community> searchProducts() {
		conn = new ConnectionDB();
		ArrayList<Community> coms = new ArrayList<Community>();

		try {
			sql = "SELECT * FROM community;";

			sentence = this.conn.pStm(sql);
			ResultSet communityFound = sentence.executeQuery();
			
			while (communityFound.next()) {
				Community com = new Community(communityFound.getString("name"));
				coms.add(com);
			}
			conn.disconnect();
			sentence.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return coms;
	}

}
