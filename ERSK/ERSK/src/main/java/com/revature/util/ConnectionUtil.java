package com.revature.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	public static Connection getConnection() throws SQLException, IOException {
		DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
		return DriverManager.getConnection(
			"jdbc:oracle:thin:@ers.cvabzhwp9hev.us-east-2.rds.amazonaws.com:1521:ORCL", 
			"erskMAINDBA", 
			"p4ssw0rd");
	}
}
