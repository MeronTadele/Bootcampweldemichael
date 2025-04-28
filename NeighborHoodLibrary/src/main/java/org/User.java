package org;

import org.example.Book;

public class User {
    private String name;
    private int checkedOutBooked;


    public User(String name, int checkedOutBooked) {
        this.name = name;
        this.checkedOutBooked = checkedOutBooked;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Book[] getCheckedOutBooked() {
        return checkedOutBooked;
    }

    public void setCheckedOutBooked(Book[] checkedOutBooked) {
        this.checkedOutBooked = checkedOutBooked;
    }

}


