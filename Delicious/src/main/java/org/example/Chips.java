package org.example;

public class Chips {
    private int chipsSize;

    public Chips(int chipsSize) {
        this.chipsSize = chipsSize;
    }

    public int getChipsSize() {
        return chipsSize;
    }

    public void setChipsSize(int chipsSize) {
        this.chipsSize = chipsSize;
    }

    @Override
    public String toString() {
        return "Chips{" +
                "chipsSize=" + chipsSize +
                '}';
    }
}
