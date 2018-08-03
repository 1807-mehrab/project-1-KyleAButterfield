package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.AdminDAO;
import com.revature.dao.AdminInfoDAO;
import com.revature.dao.ReimbursementRequestDAO;

@WebServlet(name ="DenyRequest", urlPatterns=("/denyRequest"))
public class DenyRequestServlet extends HttpServlet {
	protected void doPost (HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{
		HttpSession session = req.getSession();
		ReimbursementRequestDAO rrdao = new ReimbursementRequestDAO();
		AdminInfoDAO aidao = new AdminInfoDAO();
		AdminDAO adao = new AdminDAO();
		ObjectMapper mapper = new ObjectMapper();
		PrintWriter pw = resp.getWriter();
		int rID = (int)mapper.readValue(req.getInputStream(), Integer.class);
		int aID = (int)session.getAttribute("id");
		String name = adao.getFirstName(aID);
		name += " "; 
		name+= adao.getLastName(aID);
		rrdao.denyRequest(rID, name);
		System.out.println("The admin denied your request");
		 
	}
}
