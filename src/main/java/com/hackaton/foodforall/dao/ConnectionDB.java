package com.hackaton.foodforall.dao;

import java.sql.*;

public class ConnectionDB {
	/**
	 * Connection variable definition*/
	private String bd = "foodforall";
	private String login = "root";
	private String password = "admin";
	private String url = "jdbc:mysql://localhost/" + bd;
	private Connection connection = null;
	private PreparedStatement sentence;
	
	/**
	 * this method makes the connection to the database 
	 * through the mysql dependency, the url, user and password
	 * of the database are sent as parameters.*/
	public ConnectionDB() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, login, password);
			if (connection != null) {
				System.out.println("Conexion a base de datos " + bd + " OK\n");
			}
		} catch (ClassNotFoundException | SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	/**
	 *We will use Prepared Statement to provide additional security
	 * against sql injections and perform queries a little faster in 
	 * the database engine. */
	public PreparedStatement pStm (String sql) {
		try {
			this.sentence = connection.prepareStatement(sql);
			return this.sentence;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Method that will close the connection with the database and all the 
	 * sentences that are open, it will be called in each of the methods that 
	 * have connection with the database.*/
	public void disconnect() {
		try {
			this.sentence.close();
			this.connection.close();
			System.out.println("Disconnect");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
