package com.qmui.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DaoUtil {

	static String driver = "com.mysql.jdbc.Driver";
	static String dbUrl = "jdbc:mysql://localhost:3306/hospital";
	static String dbUser = "root";
	static String dbPassword = "tiger";

	public static Connection getConnection(){
		Connection conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static Statement getStatement(Connection conn){
		try {
			return conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}

