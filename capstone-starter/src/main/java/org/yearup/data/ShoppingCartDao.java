package org.yearup.data;

import org.yearup.models.ShoppingCart;
import org.yearup.models.ShoppingCartItem;

public interface ShoppingCartDao
{

    ShoppingCart getByUserId(int userId);
    boolean create(int userId ,int product_id);
    boolean update(int productId  , ShoppingCartItem shoppingCartItem , boolean FromAdd , int userId , int quantity);
    void delete(int userId);
}
