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
import com.revature.beans.UserInfo;
import com.revature.dao.UserInfoDAO;
@WebServlet(name ="GetUsersInfo", urlPatterns=("/getUsersInfo"))
public class GetUserInfoServlet extends HttpServlet{
	protected void doPost (HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{
		HttpSession session = req.getSession();
		UserInfoDAO uidao = new UserInfoDAO();
		ObjectMapper mapper = new ObjectMapper();
		PrintWriter pw = resp.getWriter();
		
		int id = (int) session.getAttribute("id");
		String address = uidao.getAddress(id);
		long phone = uidao.getPhone(id);
		UserInfo ui = new UserInfo(address, phone, id);
		String json = mapper.writeValueAsString(ui);
		pw.println(json);
		pw.close();
		
	}
}
