package com.revature.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.revature.dao.AdminDAO;
import com.revature.dao.UserDAO;

public class DaoTesting {
	@Test
	public void testAdminFirstName() {
		AdminDAO adao = new AdminDAO();
		int passId = 1;
		String expected = "Kyle";
		assertEquals(expected, adao.getFirstName(passId));
	}
	
	public void testAdminLastName() {
		AdminDAO adao = new AdminDAO();
		int passId = 1;
		String expected = "Butterfield";
		assertEquals(expected, adao.getLastName(passId));
	}
	
	public void testUserFirstName() {
		UserDAO udao = new UserDAO();
		int passId = 1;
		String expected = "Mark";
		assertEquals(expected, udao.getFirstName(passId));
	}
	
	public void testUserLastName() {
		UserDAO udao = new UserDAO();
		int passId = 1;
		String expected = "Bedoya";
		assertEquals(expected, udao.getFirstName(passId));
	}
	
	
}
