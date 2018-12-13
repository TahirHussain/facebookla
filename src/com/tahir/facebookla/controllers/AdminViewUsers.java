package com.tahir.facebookla.controllers;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tahir.facebookla.dao.AdminDao;
import com.tahir.facebookla.domain.UserData;

/**
 * Servlet implementation class AdminViewUsers
 */
public class AdminViewUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminViewUsers() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ResultSet rs = new AdminDao().getAllUsers();
		List<UserData> list = new ArrayList<UserData>();
		UserData u=null;
		try {

			while(rs.next()){
				u = new UserData();
				u.setId(rs.getInt(1));
				u.setfName(rs.getString(2));
				u.setSurname(rs.getString(3));
				u.setEmailId(rs.getString(4));
				u.setGender(rs.getString(6));
				list.add(u);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("listOfUsers", list);
		request.getRequestDispatcher("/adminViewUsers.jsp").forward(request, response);
	}

	
}
