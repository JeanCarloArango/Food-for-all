package com.hackaton.foodforall.dao;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import com.hackaton.foodforall.dto.Beneficiaries;

public class BeneficiariesDAO {
	
	/**
	 * Definition variables globals*/
	private ConnectionDB conn;
	private PreparedStatement sentence;
	String sql;

	/**
	 * This method receives as a parameter an object of type beneficiary
	 * which will be inserted in the database.*/
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
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * This method receives as a parameter the identification of the beneficiary
	 *  and will return a single record if the identification is given and if 
	 *  none is given, all the records in the database will be listed.*/
	public ArrayList<Beneficiaries> BeneficiariesConsult(String identify) {
		conn = new ConnectionDB();
		ArrayList<Beneficiaries> Benefi = new ArrayList<Beneficiaries>();

		try {

			if (identify == "") {
				sql = "SELECT * FROM Beneficiaries;";
				sentence = this.conn.pStm(sql);
			} else {
				sql = "SELECT * FROM Beneficiaries WHERE dni = ?;";
				sentence = this.conn.pStm(sql);
				sentence.setString(1, identify);
			}

			ResultSet res = sentence.executeQuery();

			while (res.next()) {

				Beneficiaries bene = new Beneficiaries(res.getString("dni"), res.getString("name"), res.getInt("age"),
						res.getInt("status"), res.getString("email"), res.getString("phone"),
						res.getInt("community_id"));
				Benefi.add(bene);

			}

			res.close();
			sentence.close();
			conn.disconnect();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "no se pudo consultar el beneficiario" + e);
		}
		return Benefi;

	}

}
