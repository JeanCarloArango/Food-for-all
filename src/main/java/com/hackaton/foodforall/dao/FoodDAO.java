package com.hackaton.foodforall.dao;

import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import com.hackaton.foodforall.dto.Food;

public class FoodDAO {
	
	private ConnectionDB conn;
	private PreparedStatement sentence;
	String sql;
	/**
	 
	 **/
	public ArrayList<Food> foodConsult() {
		ArrayList<Food> foods = new ArrayList<Food>();

		try {
			sql = "SELECT * FROM food;";
			sentence = this.conn.pStm(sql);
			
			ResultSet res = sentence.executeQuery();

			while (res.next()) {
				Food fo = new Food(res.getString("name"), res.getString("type"), res.getString("count"),
						res.getString("status"), res.getString("donor"));
				foods.add(fo);
			}
			res.close();
			conn.disconnect();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "no se pudo consultar la come come" + e);
		}
		return foods;
	}
	
	public void createFood(Food food) {
		
	}

}
