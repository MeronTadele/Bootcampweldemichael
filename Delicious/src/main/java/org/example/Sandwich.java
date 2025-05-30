package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sandwich {
    private double price;
    private List<Topping> meat;
    private List<Topping> cheese;
    private boolean isToasted;
    private  List<Topping> regularTopping;
    private List<Topping> sauces;
    private List<Topping> side;
    private  BreadType breadType;
    private int breadSize;

    public Sandwich( boolean isToastes, BreadType breadType, int breadSize) {
        this.price = 0;
        this.meat = new ArrayList<>();
        this.cheese = new ArrayList<>();
        this.isToasted = isToastes;
        this.regularTopping = new ArrayList<>();
        this.sauces = new ArrayList<>();
        this.side=new ArrayList<>();
        this.breadType = breadType;
        this.breadSize = breadSize;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<Topping> getMeat() {
        return meat;
    }

    public void setMeat(List<Topping> meat) {
        this.meat = meat;
    }

    public List<Topping> getCheese() {
        return cheese;
    }

    public void setCheese(List<Topping> cheese) {
        this.cheese = cheese;
    }

    public boolean isToasted() {
        return isToasted;
    }

    public void setToasted(boolean toasted) {
        isToasted = toasted;
    }

    public List<Topping> getRegularTopping() {
        return regularTopping;
    }

    public void setRegularTopping(List<Topping> regularTopping) {
        this.regularTopping = regularTopping;
    }

    public List<Topping> getSauces() {
        return sauces;
    }

    public void setSauces(List<Topping> sauces) {
        this.sauces = sauces;
    }

    public BreadType getBreadType() {
        return breadType;
    }

    public void setBreadType(BreadType breadType) {
        this.breadType = breadType;
    }

    public int getBreadSize() {
        return breadSize;
    }

    public void setBreadSize(int breadSize) {
        this.breadSize = breadSize;
    }

    public List<Topping> getSide() {
        return side;
    }

    public void setSide(List<Topping> side) {
        this.side = side;
    }


    @Override
    public String toString() {
        return "Sandwich:\n" +
                "  Bread Type: " + breadType + "\n" +
                "  Size: " + breadSize + "\"\n" +
                "  Toasted: " + isToasted + "\n" +
                "  Meats:\n" + formatToppings(meat) +
                "  Cheese:\n" + formatToppings(cheese) +
                "  Regular Toppings:\n" + formatToppings(regularTopping) +
                "  Sauces:\n" + formatToppings(sauces) +
                "  Sides:\n" + formatToppings(side);
    }

    private String formatToppings(List<Topping> toppings) {
        if (toppings.isEmpty()) return "    None\n";
        StringBuilder sb = new StringBuilder();
        for (Topping t : toppings) {
            sb.append("    ").append(t).append("\n");
        }
        return sb.toString();
    }
    }

