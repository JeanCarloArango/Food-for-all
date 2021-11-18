package com.hackaton.foodforall.dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.hackaton.foodforall.dto.Feed;

public class FeedDAO {

	public ArrayList<Feed> feedConsult() {
		ArrayList<Feed> feeds = new ArrayList<Feed>();
		ConexionBD conex = new ConexionBD();

		String sql = "SELECT * FROM feed ";

		try {
			Statement consulta = conex.getConexionBD().createStatement();
			ResultSet res = consulta.executeQuery(sql);

			while (res.next()) {
				Feed fe = new Feed(res.getString("name"), res.getString("type"), res.getString("count"),
						res.getString("status"), res.getString("donor"));
				feeds.add(fe);
			}
			res.close();
			consulta.close();
//			conex.desconectar();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "no se pudo consultar la come come" + e);
		}
		return feeds;
	}

}
