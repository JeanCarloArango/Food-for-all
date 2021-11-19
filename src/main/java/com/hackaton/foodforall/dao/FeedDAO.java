package com.hackaton.foodforall.dao;

import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import com.hackaton.foodforall.dto.*;;

public class FeedDAO {
	
	private ConnectionDB conn;
	private PreparedStatement sentence;
	String sql;
	/**
	 
	 **/
	public ArrayList<Feed> feedConsult() {

		conn = new ConnectionDB();
		ArrayList<Feed> feeds = new ArrayList<Feed>();

		try {
			sql = "SELECT * FROM feed;";
			sentence = this.conn.pStm(sql);
			
			ResultSet res = sentence.executeQuery();

			while (res.next()) {
				Feed fe = new Feed(res.getString("name"), res.getString("type"), res.getString("cantidad"),
						res.getString("status"), res.getInt("donor_id"));
				feeds.add(fe);
			}
			res.close();
			conn.disconnect();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "no se pudo consultar la come come" + e);
		}
		return feeds;
	}
	
	public Boolean createFeed(Donation feed) {
		conn = new ConnectionDB();
		try {
			int id = donorID(feed.getEmailD());
			sql = "INSERT INTO FEED (NAME, TYPE, CANTIDAD, STATUS, DONOR_ID) "
					+ "VALUES (?,?,?,?,?);";
			sentence = this.conn.pStm(sql);
			sentence.setString(1, feed.getNameF());
			sentence.setString(2, feed.getTypeF());
			sentence.setString(3, feed.getCountF());
			sentence.setString(4, feed.getStatusF());
			sentence.setInt(5, id);
			
			Boolean res = false;
			if (!sentence.execute()) {
				res = true;
				System.out.println("Se guardo");
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
	
	public int donorID (String email) {
		conn = new ConnectionDB();
		int idDonor = 0;
		try {
			sql = "SELECT * FROM DONOR WHERE EMAIL=?;";
			sentence = this.conn.pStm(sql);
			sentence.setString(1, email);
			
			ResultSet res = sentence.executeQuery();
			
			while (res.next()) {
				idDonor = res.getInt("ID");
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "no se pudo consultar la come come" + e);
		}
		return idDonor; 
	}
}
