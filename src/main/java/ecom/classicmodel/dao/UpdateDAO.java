package ecom.classicmodel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import ecom.classicmodel.model.Customer;

public class UpdateDAO {

	public void updateDetails(String encrypted, Customer customer) {

		PreparedStatement preparedStatement;
		Connection con = DatabaseConnection.getConnection();

		try {
			preparedStatement = con.prepareStatement("update customerregistration SET password = ? where username = ?");

			preparedStatement.setString(1, encrypted);
			preparedStatement.setString(2, customer.getUserName());

			int rows = preparedStatement.executeUpdate();

			System.out.println("rows");

			con.commit();
		}

		catch (SQLException e1) {
			e1.printStackTrace();
		}

	}

}
