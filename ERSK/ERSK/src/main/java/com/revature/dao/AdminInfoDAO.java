package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.revature.util.ConnectionUtil;

public class AdminInfoDAO {
	
	
	public void updateAddress(String Address, int id) {
	
		CallableStatement cs = null;
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "{CALL SP_UPDATE_Admin_ADDRESS(?,?)}";
			cs = conn.prepareCall(sql);
			cs.setString(1, Address);
			cs.setInt(2, id);
			
			
			cs.execute();
			cs.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
				
	}
	
	public void updatePhone(long l, int id) {
		
		CallableStatement cs = null;
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "{CALL SP_UPDATE_Admin_Phone(?,?)}";
			cs = conn.prepareCall(sql);
			cs.setLong(1, l);
			cs.setInt(2, id);
			
			
			cs.execute();
			cs.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
				
	}
	
	public String getAddress(int id) {
		PreparedStatement ps = null;
		String address = "";
		
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT Address FROM Admin_INFO WHERE Admin_ID =?";
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String temp = rs.getString("Address");
				address = temp;
				System.out.println(address);
				
			}
			
			
			rs.close();
			ps.close();
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		return address;
	}
	
	public long getPhone(int id) {
		PreparedStatement ps = null;
		long phone = 0;
		
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT Phone_Number FROM Admin_INFO WHERE Admin_ID =?";
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				long temp = rs.getLong("PHONE_NUMBER");
				phone = temp;
				System.out.println(phone);
			}
			
			
			rs.close();
			ps.close();
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		return phone;
	}
	
	public int getID(String username) {
		PreparedStatement ps = null;
		int adminId = 0;
		
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT Address FROM Admin_INFO WHERE Admin_ID =?";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				adminId = rs.getInt("Admin_ID");
				
				
			}
			
			
			rs.close();
			ps.close();
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		return adminId;
	}
}
