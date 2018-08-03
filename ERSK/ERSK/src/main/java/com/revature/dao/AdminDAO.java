package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Admin;
import com.revature.beans.ReimbursementRequest;
import com.revature.util.ConnectionUtil;

public class AdminDAO {
	
	public void CreateAdmin
	(String first, String last, String Username, String Pass, String Address, int Phone) {
	CallableStatement cs = null;
	
	try(Connection conn = ConnectionUtil.getConnection()) {
		String sql = "{CALL SP_CREATE_Admin(?, ?, ?, ?, ?)}";
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
	
	public List<Admin> getAllAdmins(){
		PreparedStatement ps = null;
		Admin a = null;
		List<Admin> admins = new ArrayList<Admin>();
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM Admins";
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				int Id = rs.getInt("Admin_id");
				String first = rs.getString("First_Name");
				String last = rs.getString("Last_Name");
				
				a = new Admin(first, last, Id);
				admins.add(a);
			}
			
			rs.close();
			ps.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return admins;
	}
	
	public String getFirstName(int id) {
		PreparedStatement ps = null;
		String first = "";
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT First_Name FROM Admins WHERE Admin_ID =?";
			
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
			String sql = "SELECT Last_Name FROM Admins WHERE Admin_ID =?";
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String temp = rs.getString("Last_Name");
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
