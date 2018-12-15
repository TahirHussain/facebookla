package com.tahir.facebookla.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import com.tahir.facebookla.utils.Connector;

public class LogInDao {
	
	public boolean checkInfo(String username, String password, HttpSession session){
		Connection con = Connector.getConnectionMySQL();
		try {
			PreparedStatement ps = con.prepareStatement("select userId from user where emailId = ? and password = ?");
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			rs.next();
			int id = rs.getInt("userId");
			session.setAttribute("userId", id);
			System.out.println("Aa go login");
			con.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				con.close();
			} catch (SQLException e1) {
				System.out.println("ERROR AT CON CLOSE");
				e1.printStackTrace();
			}
			System.out.println("Kiheen go na login");
			return false;
		}
		
	}

}
