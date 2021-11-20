package com.hackaton.foodforall.dao;

import java.sql.*;
import java.util.ArrayList;
import com.hackaton.foodforall.dto.Community;

public class CommunityDAO {
	/**
	 * defined variables globals*/
	private ConnectionDB conn;
	private PreparedStatement sentence;
	private String sql;
	
	/**
	 * This method will return all the locations that are registered 
	 * in the database.*/
	public ArrayList<Community> searchCommunity() {
		conn = new ConnectionDB();
		ArrayList<Community> coms = new ArrayList<Community>();

		try {
			sql = "SELECT * FROM community;";

			sentence = this.conn.pStm(sql);
			ResultSet communityFound = sentence.executeQuery();
			
			while (communityFound.next()) {
				Community com = new Community(communityFound.getInt("id"), communityFound.getString("name"));
				coms.add(com);
			}
			conn.disconnect();
			sentence.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return coms;
	}

}
