package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.ReimbursementRequest;
import com.revature.dao.ReimbursementRequestDAO;

@WebServlet(name ="GetAllUserRequestsForAdmin", urlPatterns=("/getAllRequestsForAdmin"))
public class GetAllUserRequestsForAdminServlet extends HttpServlet {
	protected void doPost (HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{
		HttpSession session = req.getSession();
		ReimbursementRequestDAO rrdao = new ReimbursementRequestDAO();
		ObjectMapper mapper = new ObjectMapper();
		PrintWriter pw = resp.getWriter();
		
		int id=(int)mapper.readValue(req.getInputStream(), Integer.class);
		
		List<ReimbursementRequest> requests = new ArrayList<ReimbursementRequest>();
		
		requests = rrdao.getAllRequestsOfUser(id);
		String json = mapper.writeValueAsString(requests);
		pw.println(json);
		pw.close();
		
		 
	}
}
