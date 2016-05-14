package com.im.debtsmanagement.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcConnectionFactory {
	private static Connection conn;
	private static String username = "root";
	private static String password = "";
	private static String url = "jdbc:mysql://localhost:3306/debts-management";
	private static String driver = "com.mysql.jdbc.Driver";

	public static Connection get() {
		if (conn == null) {
			try {
				Class.forName(driver);
				conn = DriverManager.getConnection(url, username, password);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return conn;

	}
}
