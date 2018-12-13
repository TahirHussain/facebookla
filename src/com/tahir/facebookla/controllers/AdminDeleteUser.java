package com.tahir.facebookla.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tahir.facebookla.dao.AdminDao;

/**
 * Servlet implementation class AdminDeleteUser
 */
public class AdminDeleteUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminDeleteUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		new AdminDao().deleteuser(Integer.parseInt(request.getParameter("uid")));
		response.sendRedirect(request.getContextPath()+"/admin/viewusers");
	}

}
