package com.hackaton.foodforall.dao;

import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import com.hackaton.foodforall.dto.Beneficiaries;
import com.hackaton.foodforall.dto.Feed;

public class FeedDAO {
	
	private ConnectionDB conn;
	private PreparedStatement sentence;
	String sql;
	/**
	 
	 **/
	public ArrayList<Feed> feedConsult() {
		ArrayList<Feed> feeds = new ArrayList<Feed>();

		try {
			sql = "SELECT * FROM feed;";
			sentence = this.conn.pStm(sql);
			
			ResultSet res = sentence.executeQuery();

			while (res.next()) {
				Feed fe = new Feed(res.getString("name"), res.getString("type"), res.getString("count"),
						res.getString("status"), res.getInt("donor"));
				feeds.add(fe);
			}
			res.close();
			conn.disconnect();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "no se pudo consultar la come come" + e);
		}
		return feeds;
	}
	
	public Boolean createFeed(Feed feed) {
		conn = new ConnectionDB();
		try {
			sql = "INSERT INTO FEED (NAME, TYPE, CANTIDAD, STATUS, DONOR_ID) "
					+ "VALUES (?,?,?,?,?);";
			sentence = this.conn.pStm(sql);
			sentence.setString(1, feed.getName());
			sentence.setString(2, feed.getType());
			sentence.setString(3, feed.getCount());
			sentence.setString(4, feed.getStatus());
			sentence.setInt(5, feed.getDonor());
			
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
