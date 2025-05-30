package org.example;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Order {
    private String name;
    private double price;
    private ArrayList<Sandwich> listOfSandwich; // we are using ArrayList because we might have multiple sandwichs
    private LocalDate date;
    private  LocalTime time;
    private ArrayList<Drink> drinks;
    private ArrayList<Chips> chips;

    public Order() {
        this.name = name;
        this.price = 0;
        this.listOfSandwich= new ArrayList<>();
        this.date = LocalDate.now();
        this.time = LocalTime.now();
        this.drinks = new ArrayList<>();
        this.chips = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTotalprice() {
        return price;
    }

    public void setTotalPrice(double price) {
        this.price = price;
    }

    public ArrayList<Sandwich> getListOfSandwich() {
        return listOfSandwich;
    }

    public void setListOfSandwich(ArrayList<Sandwich> listOfSandwich) {
        this.listOfSandwich=listOfSandwich;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time =time;
    }

    public  ArrayList<Drink> getDrink() {
        return drinks;
    }

    public void setDrink( ArrayList<Drink>drink) {
        this.drinks= drink;
    }

    public ArrayList<Chips>  getChips() {
        return chips;
    }

    public void setChips(ArrayList<Chips>  chips) {
        this.chips = chips;
    }

    public void AddSandwich(Sandwich sandwich){
        listOfSandwich.add(sandwich);
        System.out.println("Sandwich added:"+ sandwich);
        if(sandwich.getBreadSize()==4){
            price+=5.50;
            System.out.println(price);
        }
        else if(sandwich.getBreadSize()==8){
            price+=7.00;
            System.out.println(price);
        }
        else if(sandwich.getBreadSize()==12){
            price+=8.50;
            System.out.println(price);
        }
        }
        public void  AddMeat(ArrayList<Sandwich> sandwiches, String name,boolean extrmeat){
        Sandwich sandwich=getListOfSandwich().get(getListOfSandwich().size() - 1); // topping will be added to the to sandwich & (-1) will subtract get the index of the leastest sandwich
        sandwich.getMeat().add(new Topping(name,sandwich.getBreadSize()));
            if(sandwich.getBreadSize()==4 && extrmeat ){
                price+=0.50;
            }
            else if (sandwich.getBreadSize()==4 ) {
                price+=1.00;
            }

            else if(sandwich.getBreadSize()==8 && extrmeat){
                price+=1.00;
            } else if (sandwich.getBreadSize()==8 ) {
                price += 2.00;
            }
            else if(sandwich.getBreadSize()==12 && extrmeat) {
                price += 1.50;
            }
            else if(sandwich.getBreadSize()==12){
                price+=3.00;
            }
            System.out.println("Meat added price:" +price);
        }


        public void AddCheese(ArrayList<Sandwich> sandwiches,String name,boolean extracheese) {
            Sandwich sandwich = getListOfSandwich().get(getListOfSandwich().size() - 1);
            sandwich.getCheese().add(new Topping(name, sandwich.getBreadSize()));
            if (sandwich.getBreadSize() == 4&& extracheese) {
                price += 0.30;
            }
            else if (sandwich.getBreadSize() == 4) {
                price += 0.75;
            } else if (sandwich.getBreadSize() == 8 && extracheese) {
                price += 0.60;

            } else if (sandwich.getBreadSize() == 8) {
                price += 1.50;
            } else if (sandwich.getBreadSize() == 12 && extracheese) {
                price += 0.90;
            } else if (sandwich.getBreadSize() == 12) {
                price += 2.25;
            }
            System.out.println("Cheese price added:" + price);
        }
        public void AddregularTopping(ArrayList<Sandwich> sandwiches ,String name){
            Sandwich sandwich=getListOfSandwich().get(getListOfSandwich().size() - 1);
            sandwich.getRegularTopping().add(new RegularTopping(name,sandwich.getBreadSize()));
        }
        public void Addsauce(ArrayList<Sandwich> sandwiches,String name){
            Sandwich sandwich=getListOfSandwich().get(getListOfSandwich().size() - 1);
            sandwich.getSauces().add(new Topping(name,sandwich.getBreadSize()));
        }
        public void Addside(ArrayList<Sandwich> sandwiches,String name){
            Sandwich sandwich=getListOfSandwich().get(getListOfSandwich().size() - 1);
            sandwich.getSide().add(new Topping(name,sandwich.getBreadSize()));
        }
        public void AddDrink(Drink drink){
        drinks.add(drink);
        if(drink.getDrinkSize().equals(DrinkSize.small)){
            price+=2.00;
            System.out.println(price);
        }else if(drink.getDrinkSize().equals(DrinkSize.medium)){
            price+=2.50;
            System.out.println(price);
        }else if (drink.getDrinkSize().equals(DrinkSize.Large)){
            price+=3.00;
            System.out.println(price);
        }
        }
        public void AddChips(Chips chips1) {
            chips.add(chips1);

            price += 1.50;
            System.out.println(price);
        }

    @Override
    public String toString() {
        return "------ Checkout ------\n" +
                "Name: " + name + "\n" +
                "Date: " + date + "\n" +
                "Time: " + time + "\n" +
                "Total Price: $" + price + "\n\n" +
                "Sandwiches:\n" + formatSandwiches(listOfSandwich) +
                "Drinks: " + (drinks.isEmpty() ? "None" : drinks) + "\n" +
                "Chips: " + (chips.isEmpty() ? "None" : chips) + "\n";
    }

    private String formatSandwiches(List<Sandwich> sandwiches) { //
        StringBuilder stringBuilder = new StringBuilder();
        for (Sandwich s : sandwiches) {
            stringBuilder.append(s).append("\n\n");
        }
        return stringBuilder.toString();
    }
}



