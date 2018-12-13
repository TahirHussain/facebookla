package com.tahir.facebookla.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import com.tahir.facebookla.dao.AdminDao;
import com.tahir.facebookla.dao.LogInDao;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Reached here la");
		boolean loginStatus = new LogInDao().checkInfo(request.getParameter("emailId"),request.getParameter("password"),request.getSession());
		System.out.println("Checking the session working: "+request.getSession().getAttribute("userId"));
		if(loginStatus){
			if(request.getParameter("emailId").equals("admin")){
				//request.setAttribute("adminStatus",true );
				request.setAttribute("count", (new AdminDao().userCount()));
				request.getRequestDispatcher("adminDashboard.jsp").forward(request, response);
			}
		}
		else{
			request.setAttribute("wrongLoginStatus",true );
			System.out.println("Login info wrong!");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	Integer id = (Integer) req.getSession().getAttribute("userId"); 
		if(id !=null){
			if(id == 6){
				System.out.println("admin saeb");
				req.getRequestDispatcher("adminDashboard.jsp").forward(req, resp);
			}
		}
		else{

			resp.sendRedirect(req.getContextPath());
		}
	}

}
