package com.hackaton.foodforall.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import com.hackaton.foodforall.dto.Beneficiaries;

public class BeneficiariesDAO {
	private ConnectionDB conn;
	private PreparedStatement sentence;
	String sql;

	public Boolean createBeneficiaries(Beneficiaries ben) {
		conn = new ConnectionDB();
		try {
			// age int, status int, community int
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
