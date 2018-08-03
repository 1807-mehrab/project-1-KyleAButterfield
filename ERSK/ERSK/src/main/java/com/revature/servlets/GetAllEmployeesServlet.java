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

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Admin;
import com.revature.beans.User;
import com.revature.dao.AdminDAO;
import com.revature.dao.UserDAO;

@WebServlet(name ="GetAllEmployees", urlPatterns=("/getAllEmployees"))
public class GetAllEmployeesServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		UserDAO udao = new UserDAO();
		AdminDAO adao = new AdminDAO();
		PrintWriter pw = resp.getWriter();
		ObjectMapper mapper = new ObjectMapper();
		
		List<User> users = udao.getAllUsers();
		List<Admin> admins = adao.getAllAdmins();
		List<List> employees = new ArrayList<>();
		employees.add(users);
		employees.add(admins);
		String json = mapper.writeValueAsString(employees);
		pw.println(json);
		pw.close();
	}
}