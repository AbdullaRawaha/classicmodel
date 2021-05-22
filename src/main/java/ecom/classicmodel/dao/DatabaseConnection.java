package ecom.classicmodel.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	
	private static Connection con = null;

	 {

		String username = "root";

		try {

			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

			con = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/classicmodels?user=" + username + "&password=password");

			con.setAutoCommit(false);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {

		 Connection con = null;

		 {

			String username = "root";

			try {

				DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

				con = DriverManager
						.getConnection("jdbc:mysql://localhost:3306/classicmodels?user=" + username + "&password=password");

				con.setAutoCommit(false);
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		 }
			
		return con;
	}


}
