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
import com.revature.beans.Image;
import com.revature.dao.ImageDAO;

@WebServlet(name ="GetAllImagesByReimburseId", urlPatterns=("/getAllImagesByReimburseId"))
public class GetAllImagesByReimburseIdServlet extends HttpServlet{
	protected void doPost (HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{
			PrintWriter pw = resp.getWriter();
			ImageDAO idao = new ImageDAO();
			ObjectMapper mapper = new ObjectMapper();
			int id = (int)mapper.readValue(req.getInputStream(), Integer.class);
			List<Image> images = new ArrayList<Image>();
			images = idao.getImagesByReimburseID(id);
			if(images.size() != 0){
				Image i = images.get(0);
				System.out.println("Your image: "+i.getImage());
				
			}
			String json = mapper.writeValueAsString(images);
			pw.println(json);
			pw.close();
	}
}