package com.cleaningshop.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ConnectionManager {
	protected static Connection conn;
	protected PreparedStatement pstm;
	protected ResultSet rs;

	protected Connection generateConnection() {

		Context iniContext;

		if (conn == null) {
			try {
				iniContext = new InitialContext();
				DataSource ds = (DataSource) iniContext.lookup("java:comp/env" + "/jdbc/MySQLConnection");
				
				conn = ds.getConnection();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return conn;
	}

}
