package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.ReimbursementRequest;
import com.revature.beans.UserInfo;
import com.revature.dao.ReimbursementRequestDAO;

@WebServlet(name ="SubmitRequest", urlPatterns=("/submitRequest"))
public class SubmitRequestServlet extends HttpServlet {
	protected void doPost (HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{
		HttpSession session = req.getSession();
		ObjectMapper mapper = new ObjectMapper();
		int id = (int) session.getAttribute("id");
		ReimbursementRequestDAO rrdao = new ReimbursementRequestDAO();
		ReimbursementRequest rr = mapper.readValue(req.getInputStream(), ReimbursementRequest.class);
		
		rrdao.createRequest(id, rr.getDescription(),rr.getAmount());
	}
}