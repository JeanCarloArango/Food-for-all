package com.hackaton.foodforall.dao;

import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
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
			sql = "SELECT * FROM feed ";
			sentence = this.conn.pStm(sql);
			
			ResultSet res = sentence.executeQuery();

			while (res.next()) {
				Feed fe = new Feed(res.getString("name"), res.getString("type"), res.getString("count"),
						res.getString("status"), res.getString("donor"));
				feeds.add(fe);
			}
			res.close();
			conn.disconnect();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "no se pudo consultar la come come" + e);
		}
		return feeds;
	}

}
