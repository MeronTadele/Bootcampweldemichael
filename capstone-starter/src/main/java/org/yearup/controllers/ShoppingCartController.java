package org.yearup.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.yearup.data.ProductDao;
import org.yearup.data.ShoppingCartDao;
import org.yearup.data.UserDao;
import org.yearup.models.Category;
import org.yearup.models.ShoppingCart;
import org.yearup.models.ShoppingCartItem;
import org.yearup.models.User;

import javax.validation.Valid;
import java.security.Principal;

// convert this class to a REST controller
// only logged in users should have access to these actions
@RestController
@RequestMapping("/cart")
@CrossOrigin
public class ShoppingCartController
{
    // a shopping cart requires
    private ShoppingCartDao shoppingCartDao;
    private UserDao userDao;
    private ProductDao productDao;
     @Autowired
    public ShoppingCartController(ShoppingCartDao shoppingCartDao, UserDao userDao, ProductDao productDao) {
        this.shoppingCartDao = shoppingCartDao;
        this.userDao = userDao;
        this.productDao = productDao;
    }

    // each method in this controller requires a Principal object as a parameter
    @GetMapping
    @PreAuthorize("isAuthenticated()")
    public ShoppingCart getCart(Principal principal)
    {
        try
        {
            // get the currently logged in username
            String userName = principal.getName();
            // find database user by userId
            User user = userDao.getByUserName(userName);
            int userId = user.getId();

            // use the shoppingcartDao to get all items in the cart and return the cart
            return shoppingCartDao.getByUserId(userId);
        }
        catch(Exception e)
        {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Oops... our bad.");
        }
    }

    // add a POST method to add a product to the cart - the url should be
    // https://localhost:8080/cart/products/15 (15 is the productId to be added
    @PostMapping("/products/{product_id}")
    @PreAuthorize("isAuthenticated()")
    public ShoppingCart addProduct(Principal principal , @PathVariable int product_id) {
        if (principal == null) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "User not authenticated");
        }
        String userName = principal.getName();
        User user = userDao.getByUserName(userName);
        if (user == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found: " + userName);
        }
        int userId = user.getId();
        ShoppingCart shoppingCart = shoppingCartDao.getByUserId(userId);
        if (!shoppingCart.contains(product_id)) {
            boolean created = shoppingCartDao.create(userId, product_id);
            if (created) {
                ShoppingCart newShopping= shoppingCartDao.getByUserId(userId);
                newShopping.get(product_id);
            }

        } else if (shoppingCart.contains(product_id)) {
            shoppingCartDao.update(product_id, shoppingCart.get(product_id), true , userId , 0);
            ShoppingCart newShopping=shoppingCartDao.getByUserId(userId);

        }
        return shoppingCart;
    }


    // add a PUT method to update an existing product in the cart - the url should be
    // https://localhost:8080/cart/products/15 (15 is the productId to be updated)
    // the BODY should be a ShoppingCartItem - quantity is the only value that will be updated
    @PutMapping("/products/{product_id}")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity <Void> update(Principal principal ,@PathVariable int product_id,@RequestBody  ShoppingCartItem shoppingCartItem) {
        String userName = principal.getName();
        User user = userDao.getByUserName(userName);
        int userId = user.getId();
        boolean update = shoppingCartDao.update(product_id,shoppingCartItem,false, userId,shoppingCartItem.getQuantity());
        if(update){
            return  new ResponseEntity<>(HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            // update the category by id
        }
    }



    // add a DELETE method to clear all products from the current users cart
    // https://localhost:8080/cart
    @DeleteMapping
    @PreAuthorize("isAuthenticated()")
    public ShoppingCart delete(Principal principal){
         if (principal == null) {
             throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
         }
         String userName = principal.getName();
         User user = userDao.getByUserName(userName);
         if (user == null) {
             throw new ResponseStatusException(HttpStatus.NOT_FOUND);
         }    int userId = user.getId();
         try    {
             shoppingCartDao.delete(userId);
             return shoppingCartDao.getByUserId(userId);
         }
         catch(Exception ex) {
             throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Oops... our bad.");    }}

}
