package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Admin;
import com.revature.beans.User;
import com.revature.util.ConnectionUtil;

public class UserDAO {

	public void createUser
	(String first, String last, String Username, String Pass, String Address, int Phone) {
	CallableStatement cs = null;
	
	try(Connection conn = ConnectionUtil.getConnection()) {
		String sql = "{CALL SP_CREATE_User(?, ?, ?, ?, ?)}";
		cs = conn.prepareCall(sql);
		cs.setString(1, first);
		cs.setString(2, last);
		cs.setString(3, Username);
		cs.setString(4, Pass);
		cs.setString(5, Address);
		cs.setInt(6, Phone);
		
		cs.execute();
		cs.close();
	} catch (Exception ex) {
		ex.printStackTrace();
	}
		
	}
	
	public List<User> getAllUsers(){
		PreparedStatement ps = null;
		User u = null;
		List<User> users = new ArrayList<User>();
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM Users";
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				int Id = rs.getInt("User_id");
				String first = rs.getString("First_Name");
				String last = rs.getString("Last_Name");
				
				u = new User(first, last, Id);
				users.add(u);
			}
			
			rs.close();
			ps.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return users;
	}
	
	public String getFirstName(int id) {
		PreparedStatement ps = null;
		String first = "";
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT First_Name FROM Users WHERE User_ID =?";
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String temp = rs.getString("First_Name");
				first = temp;
				
			}
			
			
			rs.close();
			ps.close();
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		
		
		return first;
	}
	
	public String getLastName(int id) {
		PreparedStatement ps = null;
		String last = "";
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT Last_Name FROM Users WHERE User_ID =?";
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String temp = rs.getString("First_Name");
				last = temp;
				
			}
			
			
			rs.close();
			ps.close();
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		
		
		return last;
	}
}