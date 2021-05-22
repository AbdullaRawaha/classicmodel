package ecom.classicmodel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ecom.classicmodel.model.Customer;
import ecom.classicmodel.util.AES;

public class LoginDAO {

	public Customer authentication(String n, String p) {

		String encryptedString = AES.encrypt(p);

		String databaseUsername = "";
		String databasePassword = "";

		Customer customer = null;

		PreparedStatement preparedStatement;

		Connection con = DatabaseConnection.getConnection();

		try {
			preparedStatement = con.prepareStatement(
					"SELECT CustomerID, FirstName, LastName, MobileNumber, EmailID, UserName, Password FROM CustomerRegistration WHERE userName='"
							+ n + "' && password='" + encryptedString + "'");

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {

				databaseUsername = rs.getString("userName");
				databasePassword = rs.getString("password");

				if (n.equalsIgnoreCase(databaseUsername) && encryptedString.equalsIgnoreCase(databasePassword)) {

					customer = new Customer();

					customer.setCustomerID(rs.getInt(1));
					customer.setFirstName(rs.getString(2));
					customer.setLastName(rs.getString(3));
					customer.setMobileNumber(rs.getString(4));
					customer.setEmailID(rs.getString(5));
					customer.setUserName(rs.getString(6));

				}

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return customer;
	}

}
