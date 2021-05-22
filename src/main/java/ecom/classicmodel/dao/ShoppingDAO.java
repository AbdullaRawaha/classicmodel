package ecom.classicmodel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ecom.classicmodel.model.Shopping;

public class ShoppingDAO {

	public ArrayList<Shopping> shopping() {
		
		ArrayList<Shopping>shoppingList = new ArrayList<Shopping>();

		Connection con = DatabaseConnection.getConnection();

		PreparedStatement preparedStatement;

		try {

			preparedStatement = con.prepareStatement("Select * from flipkart");

			ResultSet rs = preparedStatement.executeQuery();
			
			while (rs.next()) {

				Shopping shopping = new Shopping();

				shopping.setUniq_id(rs.getString(1));
				shopping.setProduct_url(rs.getString(2));
				shopping.setProduct_name(rs.getString(3));
				shopping.setProductID(rs.getString(4));
				shopping.setRetail_price(rs.getInt(5));
				shopping.setDiscounted_price(rs.getInt(6));
				shopping.setImage(rs.getString(7));
				shopping.setDescription(rs.getString(8));
				shopping.setProduct_rating(rs.getString(9));
				shopping.setOverall_rating(rs.getString(10));
				shopping.setBrand(rs.getString(11));
				
				shoppingList.add(shopping);

			}

		} catch (SQLException e) {

			e.printStackTrace();

		}
		
		return shoppingList;
		
		 	}
}
