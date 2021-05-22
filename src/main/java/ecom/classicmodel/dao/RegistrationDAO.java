package ecom.classicmodel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ecom.classicmodel.model.Customer;
import ecom.classicmodel.util.AES;

public class RegistrationDAO {

	public boolean availibility(String userName) {

		PreparedStatement preparedStatement;

		try {
			preparedStatement = DatabaseConnection.getConnection()
					.prepareStatement("select * from CustomerRegistration where UserName =?");

			preparedStatement.setString(1, userName);

			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {

				return true;
			} else
				return false;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public void registration(Customer customer) {

		Connection con = DatabaseConnection.getConnection();

		PreparedStatement preparedStatement;

		try {

			preparedStatement = con.prepareStatement(
					"insert into CustomerRegistration(CustomerID,FirstName,LastName,MobileNumber,EmailID,UserName,Password)values(?,?,?,?,?,?,?)");

			preparedStatement.setInt(1, customer.getCustomerID());
			preparedStatement.setString(2, customer.getFirstName());
			preparedStatement.setString(3, customer.getLastName());
			preparedStatement.setString(4, customer.getMobileNumber());
			preparedStatement.setString(5, customer.getEmailID());
			preparedStatement.setString(6, customer.getUserName());

			String encryptedString = AES.encrypt(customer.getPassword());

			preparedStatement.setString(7, encryptedString);

			int rows = preparedStatement.executeUpdate();

			con.commit();

			System.out.println(rows);

		} catch (SQLException e) {
			e.printStackTrace();

			try {
				con.rollback();
			} catch (SQLException e1) {

				e1.printStackTrace();
			}

		} finally {
			try {
				con.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

	}

}
