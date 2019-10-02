package com.foodplaza.pojo;

public class Food {
private int foodId;
private String foodName,foodType,foodCategory,foodDescription;
private double foodPrice;
public int getFoodId() {
	return foodId;
}
public void setFoodId(int foodId) {
	this.foodId = foodId;
}
public String getFoodName() {
	return foodName;
}
public void setFoodName(String foodName) {
	this.foodName = foodName;
}
public String getFoodType() {
	return foodType;
}
public void setFoodType(String foodType) {
	this.foodType = foodType;
}
public String getFoodCategory() {
	return foodCategory;
}
public void setFoodCategory(String foodCategory) {
	this.foodCategory = foodCategory;
}
public String getFoodDescription() {
	return foodDescription;
}
public void setFoodDescription(String foodDescription) {
	this.foodDescription = foodDescription;
}
public double getFoodPrice() {
	return foodPrice;
}
public void setFoodPrice(double foodPrice) {
	this.foodPrice = foodPrice;
}

public Food( String foodName, String foodType, String foodCategory, String foodDescription,
		double foodPrice) {
	super();
//	this.foodId = foodId;
	this.foodName = foodName;
	this.foodType = foodType;
	this.foodCategory = foodCategory;
	this.foodDescription = foodDescription;
	this.foodPrice = foodPrice;
}


public Food(int foodId, String foodName, String foodType, String foodCategory, String foodDescription,
		double foodPrice) {
	super();
	this.foodId = foodId;
	this.foodName = foodName;
	this.foodType = foodType;
	this.foodCategory = foodCategory;
	this.foodDescription = foodDescription;
	this.foodPrice = foodPrice;
}
@Override
public String toString() {
	return "Food [foodId=" + foodId + ", foodName=" + foodName + ", foodType=" + foodType + ", foodCategory="
			+ foodCategory + ", foodDescription=" + foodDescription + ", foodPrice=" + foodPrice + "]";
}



}
