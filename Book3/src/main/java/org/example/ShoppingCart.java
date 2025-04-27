package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShoppingCart {
    private List<Product> products;

    public ShoppingCart(){
        this.products=new ArrayList<>(); // this creates empty list this is constructor with out this we cant add list we have to initiate
    }
    //TODO add product to cart method
    public void addProductToCart(Product product) { //signuter method
        products.add(product);
        System.out.println(product.getProductName() + ": item has been added. ");
    }
    //TODO remove product from cart method
    //you will need the sku of the product you want to remove
    // loop through the list of products
    //check to see if the sku matches
    // get that product,then use the remove method after that loop
    public void removeProduct(String sku){
        int listItem=0;
        boolean cartItem=false;
        String removedItemFromCart="";
       for (int i=0; i < products.size(); i++){
           Product product= products.get(i);
           if (product.getSku().equalsIgnoreCase(sku)){
               removedItemFromCart=product.getProductName();
               cartItem=true;
               listItem=i;
           }
           else if (products.size()==(i+1) && !cartItem) {
               System.out.println("invalid sku; please try again");
           }

       }
       if(cartItem){
           products.remove(listItem);
           System.out.println(removedItemFromCart + " : product has been removed from your cart! ");
       }
    }
    //TODO ger total method

    public double getCartTotal(){
        double totalSale=0;
        for (Product product : products){
            totalSale+=product.getPrice();

        }
        return totalSale;


    }

    public  void disPlayProductsINCart() {
         double totalSale=0;
        for (Product product : products){
            totalSale+=product.getPrice();
            System.out.println("Items in your cart:" + product.getProductName()+product.getSku()+product.getDepartment()
                    + product.getPrice());
        }
        System.out.println(" your total is:" +"$"+totalSale);
                }
    }


