package com.tahir.facebookla.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.tahir.facebookla.utils.Connector;

public class AdminDao {
	
	public int userCount(){
		try {
			ResultSet rs = Connector.getConnectionMySQL().createStatement().executeQuery("select count(*) as count from user");
			rs.next();
			return rs.getInt("count");
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public ResultSet getAllUsers(){
		try {
			return Connector.getConnectionMySQL().createStatement().executeQuery("select * from user");
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean deleteuser(int id){
		try {
			Connector.getConnectionMySQL().createStatement().executeUpdate("delete from user where userid="+id);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
