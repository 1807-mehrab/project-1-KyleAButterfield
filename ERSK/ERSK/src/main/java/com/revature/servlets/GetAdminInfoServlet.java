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
import com.revature.beans.AdminInfo;
import com.revature.dao.AdminInfoDAO;
@WebServlet(name ="GetAdminInfoServlet", urlPatterns=("/getAdminInfo"))
public class GetAdminInfoServlet extends HttpServlet{
	protected void doPost (HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{
		HttpSession session = req.getSession();
		AdminInfoDAO aidao = new AdminInfoDAO();
		ObjectMapper mapper = new ObjectMapper();
		PrintWriter pw = resp.getWriter();
		
		int id = (int) session.getAttribute("id");
		String address = aidao.getAddress(id);
		long phone = aidao.getPhone(id);
		AdminInfo ai = new AdminInfo(address, phone, id);
		String json = mapper.writeValueAsString(ai);
		pw.println(json);
		pw.close();
		
	}
}