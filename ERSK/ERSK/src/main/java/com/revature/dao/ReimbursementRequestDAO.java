package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.ReimbursementRequest;
import com.revature.util.ConnectionUtil;

public class ReimbursementRequestDAO {
	public ReimbursementRequest getRequest(int id) {
		PreparedStatement ps = null;
		ReimbursementRequest request = new ReimbursementRequest();
		
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM Reimbursement_Requests WHERE request_ID =?";
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				request.setStatus(rs.getString("Status"));
				request.setAmount(rs.getDouble("Amount"));
				request.setUserId(rs.getInt("User_ID"));
				request.setRequestID(id);
				request.setUpdater(rs.getString("Updater_Name"));
			}
			
			
			rs.close();
			ps.close();
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return request;
	}
	
	public void acceptRequest(int id, String name) {
		CallableStatement cs = null;
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "{CALL SP_Update_rqst(?, ?)}";
			cs = conn.prepareCall(sql);
			cs.setInt(1, id);
			cs.setString(2, name);
			
			cs.execute();
			cs.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void denyRequest(int id, String name) {
		CallableStatement cs = null;
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "{CALL SP_Deny_rqst(?,?)}";
			cs = conn.prepareCall(sql);
			cs.setInt(1, id);
			cs.setString(2, name);
			
			cs.execute();
			cs.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void createRequest(int id,String description, double amount) {
		CallableStatement cs = null;
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "{CALL SP_New_Reimburse_rqst(?, ?, ?)}";
			cs = conn.prepareCall(sql);
			cs.setInt(1, id);
			cs.setString(2, description);
			cs.setDouble(3, amount);
			
			cs.execute();
			cs.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public List<ReimbursementRequest> getAllRequests(){
		PreparedStatement ps = null;
		ReimbursementRequest r = null;
		List<ReimbursementRequest> requests = new ArrayList<ReimbursementRequest>();
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM Reimbursement_Requests";
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				int requestId = rs.getInt("Reimbursement_id");
				String description = rs.getString("Description");
				String status = rs.getString("Status");
				double amount = rs.getDouble("Amount");
				int id = rs.getInt("User_ID");
				String updater = rs.getString("Updater_Name");
				
				r = new ReimbursementRequest(requestId,description,status,amount,id,updater);
				requests.add(r);
			}
			
			rs.close();
			ps.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return requests;
	}
	
	public List<ReimbursementRequest> getAllPendingRequests(){
		PreparedStatement ps = null;
		ReimbursementRequest r = null;
		List<ReimbursementRequest> requests = new ArrayList<ReimbursementRequest>();
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM Reimbursement_Requests WHERE Status = 'Pending'";
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				int requestId = rs.getInt("Reimbursement_id");
				String description = rs.getString("Description");
				String status = rs.getString("Status");
				double amount = rs.getDouble("Amount");
				int id = rs.getInt("User_ID");
				
				r = new ReimbursementRequest(requestId,description,status,amount,id);
				requests.add(r);
			}
			
			rs.close();
			ps.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return requests;
	}
	
	public List<ReimbursementRequest> getAllDeniedRequests(){
		PreparedStatement ps = null;
		ReimbursementRequest r = null;
		List<ReimbursementRequest> requests = new ArrayList<ReimbursementRequest>();
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM Reimbursement_Requests WHERE Status = 'Denied'";
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				int requestId = rs.getInt("Reimbursement_id");
				String description = rs.getString("Description");
				String status = rs.getString("Status");
				double amount = rs.getDouble("Amount");
				int id = rs.getInt("User_ID");
				String updater = rs.getString("Updater_Name");
				
				r = new ReimbursementRequest(requestId,description,status,amount,id, updater);
				requests.add(r);
			}
			
			rs.close();
			ps.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return requests;
	}
	
	public List<ReimbursementRequest> getAllResolvedRequests(){
		PreparedStatement ps = null;
		ReimbursementRequest r = null;
		List<ReimbursementRequest> requests = new ArrayList<ReimbursementRequest>();
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM Reimbursement_Requests WHERE Status = 'Resolved'";
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				int requestId = rs.getInt("Reimbursement_id");
				String description = rs.getString("Description");
				String status = rs.getString("Status");
				double amount = rs.getDouble("Amount");
				int id = rs.getInt("User_ID");
				String updater = rs.getString("Updater_Name");
				
				r = new ReimbursementRequest(requestId,description,status,amount,id, updater);
				requests.add(r);
			}
			
			rs.close();
			ps.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return requests;
	}
	
	public List<ReimbursementRequest> getAllRequestsOfUser(int id){
		PreparedStatement ps = null;
		ReimbursementRequest r = null;
		List<ReimbursementRequest> requests = new ArrayList<ReimbursementRequest>();
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM Reimbursement_Requests WHERE USER_ID =?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				
				String description = rs.getString("Description");
				String status = rs.getString("Status");
				double amount = rs.getDouble("Amount");
				int requestId = rs.getInt("Reimbursement_ID");
				String updater = rs.getString("Updater_Name");
				
				r = new ReimbursementRequest(requestId,description,status,amount,id,updater);
				requests.add(r);
			}
			
			rs.close();
			ps.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return requests;
	}
	
	public List<ReimbursementRequest> getAllPendingRequestsOfUser(int id){
		PreparedStatement ps = null;
		ReimbursementRequest r = null;
		List<ReimbursementRequest> requests = new ArrayList<ReimbursementRequest>();
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM Reimbursement_Requests WHERE USER_ID =? AND Status='Pending'";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				
				String description = rs.getString("Description");
				String status = rs.getString("Status");
				double amount = rs.getDouble("Amount");
				int requestId = rs.getInt("Reimbursement_ID");
				String updater = rs.getString("Updater_Name");
				
				r = new ReimbursementRequest(requestId,description,status,amount,id, updater);
				requests.add(r);
			}
			
			rs.close();
			ps.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return requests;
	}
	
	public List<ReimbursementRequest> getAllDeniedRequestsOfUser(int id){
		PreparedStatement ps = null;
		ReimbursementRequest r = null;
		List<ReimbursementRequest> requests = new ArrayList<ReimbursementRequest>();
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM Reimbursement_Requests WHERE USER_ID =? AND Status='Denied'";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				
				String description = rs.getString("Description");
				String status = rs.getString("Status");
				double amount = rs.getDouble("Amount");
				int requestId = rs.getInt("Reimbursement_ID");
				String updater = rs.getString("Updater_Name");
				
				r = new ReimbursementRequest(requestId,description,status,amount,id, updater);
				requests.add(r);
			}
			
			rs.close();
			ps.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return requests;
	}
	
	public List<ReimbursementRequest> getAllResolvedRequestsOfUser(int id){
		PreparedStatement ps = null;
		ReimbursementRequest r = null;
		List<ReimbursementRequest> requests = new ArrayList<ReimbursementRequest>();
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM Reimbursement_Requests WHERE USER_ID =? AND Status='Resolved'";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				
				String description = rs.getString("Description");
				String status = rs.getString("Status");
				double amount = rs.getDouble("Amount");
				int requestId = rs.getInt("Reimbursement_ID");
				String updater = rs.getString("Updater_Name");
				
				r = new ReimbursementRequest(requestId,description,status,amount,id, updater);
				requests.add(r);
			}
			
			rs.close();
			ps.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return requests;
	}
}
