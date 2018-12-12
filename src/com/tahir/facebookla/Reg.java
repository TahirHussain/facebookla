package com.tahir.facebookla;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tahir.facebookla.dao.RegisterDao;
import com.tahir.facebookla.domain.UserData;

/**
 * Servlet implementation class Reg
 */

public class Reg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Reg() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest rq, HttpServletResponse rp) throws ServletException, IOException {
		UserData u = new UserData();
		u.setfName(rq.getParameter("firstName"));
		u.setSurname(rq.getParameter("surname"));
		u.setEmailId(rq.getParameter("emailId"));
		u.setPassword(rq.getParameter("password"));
		u.setGender(rq.getParameter("gender"));
		new RegisterDao().registerUser(u);
		rq.setAttribute("signedUp", true);
		RequestDispatcher rd = rq.getRequestDispatcher("index.jsp");
		rd.forward(rq, rp);
	}

}
