package org.yearup.data;

import org.yearup.models.ShoppingCart;
import org.yearup.models.ShoppingCartItem;

public interface ShoppingCartDao
{

    ShoppingCart getByUserId(int userId);
    ShoppingCart create(int userId ,int product_id);
    boolean update(int productId  , ShoppingCartItem shoppingCartItem , boolean FromAdd , int userId , int quantity);
    ShoppingCart delete(int userId);
}
