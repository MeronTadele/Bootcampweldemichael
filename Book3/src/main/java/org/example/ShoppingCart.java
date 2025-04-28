package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShoppingCart {
    private List<Product> products;

    public ShoppingCart(){
        this.products=new ArrayList<>(); // this creates empty list this is constructor with out this we cant add list we have to initiate
    }

    public void addProductToCart(Product product) { //signuter method
        products.add(product);
        System.out.println(product.getProductName() + ": item has been added. ");
    }

    public void removeProduct(String sku){ // method for case 3
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
           else if (products.size()==(i+1) && !cartItem) { // if user input is wrong product
               System.out.println("invalid sku; please try again");
           }

       }
       if(cartItem){
           products.remove(listItem);
           System.out.println(removedItemFromCart + " : product has been removed from your cart! ");
       }
    }


    public double getCartTotal(){
        double totalSale=0;
        for (Product product : products){
            totalSale+=product.getPrice();

        }
        return totalSale;


    }

    public  void disPlayProductsINCart() { //method for case 2
         double totalSale=0;
        for (Product product : products){
            totalSale+=product.getPrice();
            System.out.println("Items in your cart:" + product.getProductName()+product.getSku()+product.getDepartment()
                    + product.getPrice());
        }
        System.out.println(" your total is:" +"$"+totalSale);
                }
    }


