package com.foodplaza.dao;

import java.util.List;

public interface CartDao {
   boolean addToCart(Cart cart);
   boolean updateCart(int foodQty, int cartId);
   boolean deleteCart(int cartId);
   boolean clearCart(String custemailid);
   List<Cart> showCart (String custemailid);
}
