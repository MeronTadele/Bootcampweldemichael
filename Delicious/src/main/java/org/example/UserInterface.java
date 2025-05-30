package org.example;

import java.util.Scanner;

public class UserInterface {
    public void menu() {
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println();
                System.out.println("****** Welcome to Mary and the Sandwich ********");
                System.out.println();
                System.out.println("1) New Order");
                System.out.println("0) Exit");
                int option = Integer.parseInt(scanner.nextLine());
                switch (option) {
                    case 1:
                        newOrder(scanner);
                        break;
                    case 0:
                        System.exit(0);

                }
            } catch (NumberFormatException ex) {
                System.out.println(" invalid.....");
            }
        }
    }

    public void newOrder(Scanner scanner) {
        boolean ordering = true;
        Order order = new Order();
        while (ordering) {
            try {

                System.out.println("2) Add sandwich");
                System.out.println("3) Add drink");
                System.out.println("4) Add CHips");
                System.out.println("6) Checkout");
                System.out.println("7) Cancel Order");
                int choose = Integer.parseInt(scanner.nextLine());
                switch (choose) {
                    case 2:
                        getSandwichOrder(scanner, order);
                        break;
                    case 3:
                        drink(scanner, order);
                        break;
                    case 4:
                        chips(scanner, order);
                        break;
                    case 5:
                        //entree(scanner, order);
                        break;
                    case 6:
                        checkOut(scanner, order);
                        //ordering = false;
                        break;
                    case 7:
                        System.out.println("Order has been cancelled.");
                        order.getListOfSandwich().clear();
                        order.getChips().clear();
                        order.getDrink().clear();
                        ordering = false;

                        break;
                    default:
                        System.out.println("invalid option");
                }
            } catch (NumberFormatException ex) {
                System.out.println(" Error... Enter valid number!");
            }
        }
    }


    public void getSandwichOrder(Scanner scanner, Order order) {
        BreadType breadType = null;
        while (true) {
            try {

                System.out.println("Select your Bread type: 1)white 2)wheat 3)wrap 4)rye 0) go back");
                int bread = Integer.parseInt(scanner.nextLine());
                if (bread == 1) {
                    breadType = BreadType.white;
                    break;
                } else if (bread == 2) {
                    breadType = BreadType.wheat;
                    break;
                } else if (bread == 3) {
                    breadType = BreadType.wrap;
                    break;
                } else if (bread == 4) {
                    breadType = BreadType.rye;
                    break;
                } else if (bread == 0) {
                    break;
                }
            } catch (IllegalArgumentException ex) {
                System.out.println("Enter the invalid input!");
            }
        }
        int size = 0;
        while (true) {
            try {
                System.out.println("Select your Bread size: 1) 4\" 2) 8\" 3) 12\" ");// \" will put as m for inch
                int size1 = Integer.parseInt(scanner.nextLine());
                if (size1 == 1) {
                    size = 4;
                    break; // will stop infinite loop and prevent from error incorrect answer.
                } else if (size1 == 2) {
                    size = 8;
                    break;
                } else if (size1 == 3) {
                    size = 12;
                    break;
                }
            } catch (NumberFormatException ex) {
                System.out.println("input valid format.");
            }
        }
        while (true) {
            try {
                System.out.println(" would you like the sandwich toasted? 1) yes 2) No");
                int toast = Integer.parseInt(scanner.nextLine());
                if (toast == 1) {
                    order.AddSandwich(new Sandwich(true, breadType, size));
                    break;
                } else if (toast == 2) {
                    order.AddSandwich(new Sandwich(false, breadType, size));
                    break;
                }
            } catch (NumberFormatException ex) {
                System.out.println("input valid format");
            }
        }
        boolean addingToppings = true;
        while (addingToppings) {
            try {
                System.out.println("pick your Toppings");
                System.out.println("1) Meat 2) Cheese 3)regular Toppings 4) sauce 5) side 6) No Topping / Done");
                int topping = Integer.parseInt(scanner.nextLine());
                if (topping == 1) {
                    while (true) {
                        try {
                            System.out.println(" a)steak b)ham c)salami d)roast beef e)chicken f)bacon g) go back ");
                            String meatChoice = scanner.nextLine();
                            if (meatChoice.equalsIgnoreCase("a")) {
                                order.AddMeat(order.getListOfSandwich(), "steak", false);
                                break;
                            } else if (meatChoice.equalsIgnoreCase("b")) {
                                order.AddMeat(order.getListOfSandwich(), "ham", false);
                                break;
                            } else if (meatChoice.equalsIgnoreCase("c")) {
                                order.AddMeat(order.getListOfSandwich(), "salami", false);
                                break;
                            } else if (meatChoice.equalsIgnoreCase("d")) {
                                order.AddMeat(order.getListOfSandwich(), "roast beef", false);
                                break;
                            } else if (meatChoice.equalsIgnoreCase("e")) {
                                order.AddMeat(order.getListOfSandwich(), "chicken", false);
                                break;
                            } else if (meatChoice.equalsIgnoreCase("f")) {
                                order.AddMeat(order.getListOfSandwich(), "bacon", false);
                                break;
                            }
                        } catch (Exception ex) {
                            System.out.println("invalid");
                        }
                        System.out.println(" would you like to have extra meat? a)yes b)no");
                        String extra = scanner.nextLine();
                        if (extra.equalsIgnoreCase("a")) {
                            order.AddMeat(order.getListOfSandwich(), "Extra meat", true);
                            System.out.println("Extra meat added.");
                            break;
                        } else {
                            System.out.println("No extra meat added");
                            break;
                        }
                    }
                } else if (topping == 2) {
                    while (true) {
                        System.out.println(" a)american b)provolone c)cheddar d)swiss");
                        String cheese = scanner.nextLine();
                        if (cheese.equalsIgnoreCase("a")) {
                            order.AddCheese(order.getListOfSandwich(), "american", false);
                            break;
                        } else if (cheese.equalsIgnoreCase("b")) {
                            order.AddCheese(order.getListOfSandwich(), "provolone", false);
                            break;
                        } else if (cheese.equalsIgnoreCase("c")) {
                            order.AddCheese(order.getListOfSandwich(), "cheddar", false);
                            break;
                        } else if (cheese.equalsIgnoreCase("d")) {
                            order.AddCheese(order.getListOfSandwich(), "swiss", false);
                            break;
                        }
                        System.out.println(" would you like to have extra cheese? a)yes b) no ");
                        String extracheese = scanner.nextLine();
                        if (extracheese.equalsIgnoreCase("a")) {
                            System.out.println("Enter cheese:a)american b)provolone c)cheddar d)swiss e) go back");
                            String cheeseExtra = scanner.nextLine();
                            order.AddCheese(order.getListOfSandwich(), "Extra cheese", true);
                            break;
                        }
                    }
                } else if (topping == 3) {
                    while (true) {
                        try {

                            System.out.println("1)lettuce,2)peppers,3)onions,4)tomatoes,5)jalapenos,6)cucumbers,7)pickles,8)guacamole,9)mushrooms 0) NO regularTop / go back");
                            String input = scanner.nextLine();

                            if (input.equals("0")) {
                                System.out.println("Finished selecting Regular toppings.");
                                break;
                            }

                            if (input.equals("1")) {
                                order.AddregularTopping(order.getListOfSandwich(), "Lettuce");
                                break;
                            } else if (input.equals("2")) {
                                order.AddregularTopping(order.getListOfSandwich(), "Peppers");
                                break;
                            } else if (input.equals("3")) {
                                order.AddregularTopping(order.getListOfSandwich(), "Onions");
                                break;
                            } else if (input.equals("4")) {
                                order.AddregularTopping(order.getListOfSandwich(), "Tomatoes");
                                break;
                            } else if (input.equals("5")) {
                                order.AddregularTopping(order.getListOfSandwich(), "Jalapenos");
                                break;
                            } else if (input.equals("6")) {
                                order.AddregularTopping(order.getListOfSandwich(), "Cucumbers");
                                break;
                            } else if (input.equals("7")) {
                                order.AddregularTopping(order.getListOfSandwich(), "Pickles");
                                break;
                            } else if (input.equals("8")) {
                                order.AddregularTopping(order.getListOfSandwich(), "Guacamole");
                                break;
                            } else if (input.equals("9")) {
                                order.AddregularTopping(order.getListOfSandwich(), "Mushrooms");
                                break;
                            } else {
                                System.out.println("Invalid input. Please enter a number between 0 and 9.");

                            }
                        } catch (IllegalArgumentException ex) {
                            System.out.println("invalid Input");
                        }
                    }

                } else if (topping == 4) {
                    while (true) {
                        try {
                            System.out.println("1)mayo,2)mustard,3)Ketchup,4)ranch,5)thousand islands,6)vinaigrette,0) no sauce / go back");
                            String saucesYes = (scanner.nextLine());
                            if (saucesYes.equals("0")) {
                                System.out.println("Finished selecting sauces.");
                                break;
                            }
                            if (saucesYes.equals("1")) {
                                order.Addsauce(order.getListOfSandwich(), "Mayo");
                                break;
                            } else if (saucesYes.equals("2")) {
                                order.Addsauce(order.getListOfSandwich(), "Mustard");
                                break;
                            } else if (saucesYes.equals("3")) {
                                order.Addsauce(order.getListOfSandwich(), "Ketchup");
                                break;
                            } else if (saucesYes.equals("4")) {
                                order.Addsauce(order.getListOfSandwich(), "Ranch");
                                break;
                            } else if (saucesYes.equals("5")) {
                                order.Addsauce(order.getListOfSandwich(), "Thousand Islands");
                                break;
                            } else if (saucesYes.equals("6")) {
                                order.Addsauce(order.getListOfSandwich(), "Vinaigrette");
                                break;
                            } else {
                                System.out.println("Invalid input. Please enter a number between 0 and 6.");
                            }
                        } catch (Exception ex) {
                            System.out.println("Try again");
                        }
                    }

                } else if (topping == 5) {
                    while (true) {
                        try {
                            System.out.println("1) au jus, 2) sauce");
                            String sideYes = (scanner.nextLine());
                            if (sideYes.equalsIgnoreCase("1")) {
                                order.Addside(order.getListOfSandwich(), sideYes);
                                break;
                            } else if (sideYes.equalsIgnoreCase("2")) {
                                order.Addside(order.getListOfSandwich(), sideYes);
                                break;
                            }
                        } catch (NumberFormatException exception) {
                            System.out.println("invalid");
                        }
                    }
                } else if (topping == 6) {
                    addingToppings = false;
                } else {
                    System.out.println("Try again.");
                }
            } catch (NumberFormatException ex) {
                System.out.println("invalid try again!");
            }
        }
    }

    public void drink(Scanner scanner, Order order) {
        while (true) {
            try {
                System.out.println("Select your drink size: 1)Large, 2)Medium ,3)Small, 0) go back.");
                int drinks = Integer.parseInt(scanner.nextLine());
                if (drinks == 1) {
                    order.AddDrink(new Drink(DrinkSize.Large));
                    break;
                } else if (drinks == 2) {
                    order.AddDrink(new Drink(DrinkSize.medium));
                    break;
                } else if (drinks == 3) {
                    order.AddDrink(new Drink(DrinkSize.small));
                    break;
                } else if (drinks == 0) {
                    break;
                }

            } catch (IllegalArgumentException ex) {
                System.out.println("invalid input! Enter invalid number.");

            }
        }
    }

    public void chips(Scanner scanner, Order order) {
        while (true) {
            try {
                System.out.println("Select your Chips size. 1) large 2)Medium 3) small 4) No chips / go back");
                int chip = Integer.parseInt(scanner.nextLine());
                if (chip == 1) {
                    order.AddChips(new Chips(chip));
                    break;
                } else if (chip == 2) {
                    order.AddChips(new Chips(chip));
                    break;
                } else if (chip == 3) {
                    order.AddChips(new Chips(chip));
                    break;
                } else if (chip == 0) {
                    break;
                }
            } catch (NumberFormatException ex) {
                System.out.println("invalid.");
            }
        }
    }

    public void checkOut(Scanner scanner, Order order) {
        boolean cancelOrder = true;
        while (cancelOrder) {
            try {
                System.out.println("Enter your name.");
                String name = scanner.nextLine();
                order.setName(name);
                System.out.println("\n------ Checkout -----");
                System.out.println();
                System.out.println(" your order summary");
                System.out.println();
                System.out.println(order);
                System.out.println("Would you like to proceed with your checkout?");
                System.out.println("1) Confirm");
                //System.out.println("2) remove item");//todo
                System.out.println("0) Cancel");
                int checkout = Integer.parseInt(scanner.nextLine());
                if (checkout == 1) {
                    OrderFileManager orderFileManager = new OrderFileManager();
                    orderFileManager.saveOrder(order);
                    System.out.println("Thank you " + " " + name + " " + "your order is placed successfully!");
                    System.out.printf("Total: $%.2f%n", order.getTotalprice());
                    break;
                } else if (checkout == 0) {
                    cancelOrder = false;
                    break;
                }

            } catch (NumberFormatException ex) {
                System.out.println(" input valid number.");
            }
        }

    }

}








