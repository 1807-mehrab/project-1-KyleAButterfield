package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.dao.LoginDAO;

@WebServlet(name ="LoginUserServlet", urlPatterns=("/login"))
public class LoginUserServlet extends HttpServlet{

	protected void doPost (HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{
		HttpSession session = req.getSession();
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		boolean usernameExists = false;
		boolean passwordExists = false;
		LoginDAO lg = new LoginDAO();
		
		usernameExists = lg.CheckUserUsername(username);
		passwordExists = lg.CheckUserPassword(username, password);
		
		
		if(usernameExists == true && passwordExists == true) {
			session.setAttribute("username", username);
			int id = lg.getUserID(username);
			session.setAttribute("id", id);
			RequestDispatcher rd = req.getRequestDispatcher("EmployeeHomePage.html");
			rd.forward(req, resp);	
		}else {
			RequestDispatcher rd = req.getRequestDispatcher("Index.html");
			rd.forward(req, resp);
		}
		
	}
}
	