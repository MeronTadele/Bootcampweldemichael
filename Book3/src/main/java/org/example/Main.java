package org.example;

import java.io.FileReader;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        menu();// calling method
    }

    public static void menu() { // method for user to select option

        Scanner scanner = new Scanner(System.in);
        ShoppingCart shoppingCart = new ShoppingCart();
        while (true) {
            // this my option menu for my user
            System.out.println("Welcome to MyShop Online Store");
            System.out.println("1) display all products");
            System.out.println("2) display cart");
            System.out.println("3) Remove item");
            System.out.println("4) Check out");
            System.out.println("5) exit");

            int shopping = scanner.nextInt();

            switch (shopping) {
                case 1:
                    displayProducts(scanner, shoppingCart);
                    break;
                case 2:
                    shoppingCart.disPlayProductsINCart();
                    break;
                case 3:
                    System.out.println("what is your SKU that you want to remove? ");
                    scanner.nextLine();
                    String sku = scanner.nextLine();
                    shoppingCart.removeProduct(sku);
                    break;
                case 4:
                    checkOut(scanner, shoppingCart);
                    break;
                case 5:
                    System.exit(0);
                    break;

                default:
                    System.out.println("invalid");
                    break;
            }
        }
    }

    public static void displayProducts(Scanner scanner, ShoppingCart shoppingCart) { //method for my case 1 and
        //i add my option under here for user to add and search product
        List<Product> products = FileLoader.readFile();// my product list
        for (Product product : products) {
            System.out.println(product.getProductName());// name of my all product list
        }
        boolean page = true;
        while (page) {
            System.out.println("                               ");
            System.out.println("what would you like to do?");
            System.out.println("1) search product by SKU");
            System.out.println("2) add product to cart");
            System.out.println("3) go back to home page");
            int option = scanner.nextInt();
            if (option == 1) {

                for (Product product : products) {
                    scanner.nextLine();
                    String pick = scanner.nextLine();// ask user to input
                    if (product.getSku().equals(pick)) {// verify if the user input matches the sku
                        System.out.println("product found:" + product.getSku());
                    }
<<<<<<< HEAD
=======
            
>>>>>>> e0c44341591faf7b9c03e77e39a65e31a3bcbfe4
                    else {
                        System.out.println(" invalid input! ");
                    }
                }
            }
            if (option == 2) {
                System.out.println(" what is your sku? ");
                scanner.nextLine();
                String addProduct = scanner.nextLine();

                boolean itemHas = false;
                for (int i = 0; i < products.size(); i++) {
                    Product product = products.get(i);
                    if (addProduct.equalsIgnoreCase(product.getSku())) {
                        shoppingCart.addProductToCart(product);
                        itemHas = true; // if user input is wrong I will tell them to try again
                    } else if (products.size() == (i + 1) && !itemHas) {
                        System.out.println("invalid sku; please try again! ");
                    }

                }
                break;


            }
            if (option == 3) {
                page = false; // go back to the home page
                break;
            }
        }


    }

    public static void checkOut(Scanner scanner, ShoppingCart shoppingCart) { // case 4 method
        boolean noChoice = true;
        while (noChoice) {
            try {
                shoppingCart.disPlayProductsINCart(); // call my method from my shoppingCart class

                System.out.println("                             ");
                System.out.println(" would you like to make a payment? ");
                System.out.println("1) yes ");
                System.out.println("2) no ");
                scanner.nextLine();
                int choice = Integer.parseInt(scanner.nextLine());
                if (choice == 1) {
                    System.out.println("Enter your payment.");
                    double paymentCash = scanner.nextDouble();
                    if (paymentCash < shoppingCart.getCartTotal()) {// user payment is less than the total sale
                        System.out.println(" insufficient balance. ");
                    } else if (paymentCash > shoppingCart.getCartTotal()) { // if user need change
                        paymentCash -= shoppingCart.getCartTotal();
                        System.out.printf("here is your change:$%.2f ", paymentCash);

                    } else {
                        // if user input is exact change. by default this will display
                        System.out.println(" Thank you for shopping at Myshop Store! Please COME BACK AGAIN :) ");
                    }


                }
                if (choice == 2) {
                    noChoice=false;// go back to the home page


                }

            } catch (Exception ex) {
                System.out.println(" error!!!! ");

            }

        }

    }
}
