package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.UserInfo;
import com.revature.dao.UserInfoDAO;

@WebServlet(name ="UpdateUsersInfo", urlPatterns=("/updateUsersInfo"))
public class UpdateUsersInfoServlet  extends HttpServlet{
	protected void doPost (HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{
		HttpSession session = req.getSession();
		ObjectMapper mapper = new ObjectMapper();
		int id = (int) session.getAttribute("id");
		UserInfoDAO uidao = new UserInfoDAO();
		UserInfo ui = mapper.readValue(req.getInputStream(), UserInfo.class);
		
		uidao.updateAddress(ui.getAddress(), id);
		uidao.updatePhone(ui.getPhone(), id);
		
	}
}