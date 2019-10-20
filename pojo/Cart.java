package com.foodplaza.pojo;

public class Cart {
 
	private int cartId, foodId, foodqty;
	private String foodName, custemailid;
	private double foodPrice;
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public int getFoodId() {
		return foodId;
	}
	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}
	public int getFoodqty() {
		return foodqty;
	}
	public void setFoodqty(int foodqty) {
		this.foodqty = foodqty;
	}
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public String getCustemailid() {
		return custemailid;
	}
	public void setCustemailid(String custemailid) {
		this.custemailid = custemailid;
	}
	public double getFoodPrice() {
		return foodPrice;
	}
	public void setFoodPrice(double foodPrice) {
		this.foodPrice = foodPrice;
	}
	public Cart(int foodId, int foodqty, String foodName, String custemailid, double foodPrice) {
		super();
		this.foodId = foodId;
		this.foodqty = foodqty;
		this.foodName = foodName;
		this.custemailid = custemailid;
		this.foodPrice = foodPrice;
	}
	public Cart() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", foodId=" + foodId + ", foodqty=" + foodqty + ", foodName=" + foodName
				+ ", custemailid=" + custemailid + ", foodPrice=" + foodPrice + "]";
	}
	
	
}
