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

	@SuppressWarnings("serial")
	@WebServlet(name ="Logout", urlPatterns=("/logout"))
	public class LogoutServlet extends HttpServlet{


		protected void doGet (HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException{
			HttpSession session = req.getSession();
			System.out.println("We are in logout");
				session.invalidate();
				
				System.out.println("We are in log out!!!!!!!!!");
				req.getRequestDispatcher("Index.html").forward(req, resp);
				
			}
			
	}

		
