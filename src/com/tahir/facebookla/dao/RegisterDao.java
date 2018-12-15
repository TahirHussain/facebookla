package com.tahir.facebookla.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.tahir.facebookla.domain.UserData;
import com.tahir.facebookla.utils.Connector;

public class RegisterDao {
	public void registerUser(UserData u){
		Connection con = Connector.getConnectionMySQL();
		try {
			int index;
			ResultSet r = con.createStatement().executeQuery("select MAX(USERId) as count from user");
			r.next();
			index = r.getInt("count")+1;
			System.out.println(index);
			System.out.println("COUNT LAAAA"+index);
			java.sql.PreparedStatement p = con.prepareStatement("insert into user values (?,?,?,?,?,?)");
			p.setInt(1, index);
			p.setString(2, u.getfName());
			p.setString(3, u.getSurname());
			p.setString(4, u.getEmailId());
			p.setString(5, u.getPassword());
			p.setString(6, u.getGender());
			p.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				con.createStatement().executeUpdate(
						"create table user("
						+ "userId int NOT NULL,"
						+ "firstName varchar(80),"
						+ "surname varchar(80),"
						+ "emailId varchar(80),"
						+ "password varchar(20),"
						+ "gender varchar(10),"
						+ "PRIMARY KEY (userId)"
						+ ");");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			java.sql.PreparedStatement p;
			try {
				p = con.prepareStatement("insert into user values (?,?,?,?,?,?)");
				p.setInt(1, 1);
				p.setString(2, u.getfName());
				p.setString(3, u.getSurname());
				p.setString(4, u.getEmailId());
				p.setString(5, u.getPassword());
				p.setString(6, u.getGender());
				p.executeUpdate();
			}catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		}
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
