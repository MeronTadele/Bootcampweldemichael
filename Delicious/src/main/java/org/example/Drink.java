package org.example;

public class Drink {
    private DrinkSize drinkSize;

    public Drink(DrinkSize drinkSize) {
        this.drinkSize = drinkSize;
    }

    public DrinkSize getDrinkSize() {
        return drinkSize;
    }

    public void setDrinkSize(DrinkSize drinkSize) {
        this.drinkSize = drinkSize;
    }

    @Override
    public String toString() {
        return "Drink{" +
                "drinkSize=" + drinkSize +
                '}';
    }
}
