package com.foodplaza.dao;

import java.util.List;

import com.foodplaza.pojo.Food;

public interface FoodDao {
boolean addFood(Food food);
boolean updateFood(Food food);
boolean deleteFood (int foodId);
List<Food> getAllFood();
Food searchFoodById(int foodId);
List<Food> searchFoodByName(String foodName);
List<Food> searchFoodByCategory(String foodCategory);
}
