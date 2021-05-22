package ecom.classicmodel.model;

import java.util.ArrayList;

public class Shopping {

	private String uniq_id;
	private String product_url;
	private String product_name;
	private String productID;
	private int retail_price;
	private int discounted_price;
	private String image;
	private String description;
	private String product_rating;
	private String overall_rating;
	private String brand;
	private ArrayList<Shopping> shoppingList;
	
	
	
	

	public String getUniq_id() {
		return uniq_id;
	}

	public void setUniq_id(String uniq_id) {
		this.uniq_id = uniq_id;
	}

	public String getProduct_url() {
		return product_url;
	}

	public void setProduct_url(String product_url) {
		this.product_url = product_url;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getProductID() {
		return productID;
	}

	public void setProductID(String productID) {
		this.productID = productID;
	}

	public int getRetail_price() {
		return retail_price;
	}

	public void setRetail_price(int retail_price) {
		this.retail_price = retail_price;
	}

	public int getDiscounted_price() {
		return discounted_price;
	}

	public void setDiscounted_price(int discounted_price) {
		this.discounted_price = discounted_price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getProduct_rating() {
		return product_rating;
	}

	public void setProduct_rating(String product_rating) {
		this.product_rating = product_rating;
	}

	public String getOverall_rating() {
		return overall_rating;
	}

	public void setOverall_rating(String overall_rating) {
		this.overall_rating = overall_rating;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public ArrayList<Shopping> getShoppingList() {
		return shoppingList;
	}

	public void setShoppingList(ArrayList<Shopping> shoppingList) {
		this.shoppingList = shoppingList;
	}

}
