package com.foodplaza.dao;

import com.foodplaza.pojo.Cart;
import java.util.List;

public interface CartDao {
   boolean addToCart(Cart cart);
   boolean updateCart(int foodQty, int cartId);
   boolean deleteCart(int cartId);
   boolean clearCart(String custemailid);
   Arraylist<Cart> showCart (String custemailid);
}
