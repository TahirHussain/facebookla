package com.tahir.facebookla.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {
	
	public static Connection getConnectionMySQL(){
		Connection con=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/facebookla","root","");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			try {
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306","root","");
				con.createStatement().executeUpdate("create database facebookla");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/facebookla","root","");
				return con;
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		return con;
	}

}
