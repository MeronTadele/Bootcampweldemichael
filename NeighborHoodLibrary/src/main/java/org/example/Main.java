package org.example;

import org.User;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // i will instantiate a class Array that holds 20 books []
        Book[] inventory = new Book[20];
        // i have my 20 books inventory with all 5 properties
        Book book = new Book(0, "976098927494", "how to win", true, "mary", "10 days from today");
        Book book1 = new Book(1, "9780140449136", "The Odyssey", false, "", "");
        Book book2 = new Book(2, "9780679783275", "Pride and Prejudice", true, "Alice Johnson", "10 days from today");
        Book book3 = new Book(3, "9780061120084", "To Kill a Mockingbird", false, "", "");
        Book book4 = new Book(4, "9780451524935", "1984", true, "David Smith", "10 days from today");
        Book book5 = new Book(5, "9780743273565", "The Great Gatsby", false, "", "");
        Book book6 = new Book(6, "9780141439600", "Wuthering Heights", false, "", "");
        Book book7 = new Book(7, "9780140449266", "Crime and Punishment", true, "Emma Davis", "10 days from today");
        Book book8 = new Book(8, "9780142424171", "The Fault in Our Stars", false, "", "");
        Book book9 = new Book(9, "9780316769488", "The Catcher in the Rye", true, "Liam Brown", "10 days from today");
        Book book10 = new Book(10, "9780140283334", "Brave New World", false, "", "");
        Book book11 = new Book(11, "9780143105984", "Jane Eyre", true, "Sophia Miller", "10 days from today");
        Book book12 = new Book(12, "9780140449181", "Les Misérables", false, "", "");
        Book book13 = new Book(13, "9780141182537", "A Portrait of the Artist as a Young Man", false, "", "");
        Book book14 = new Book(14, "9780141439518", "Great Expectations", true, "Noah Garcia", "10 days from today");
        Book book15 = new Book(15, "9780141441146", "Anna Karenina", false, "", "");
        Book book16 = new Book(16, "9780385472579", "The Things They Carried", true, "Isabella Martinez", "10 days from today");
        Book book17 = new Book(17, "9780141439587", "Dracula", false, "", "");
        Book book18 = new Book(18, "9780743482745", "Hamlet", true, "Mason Lee", "10 days from today");
        Book book19 = new Book(19, "9780142437209", "Moby Dick", false, "", "");



        // add books to the array
        inventory[0] = book;
        inventory[1] = book1;
        inventory[2] = book2;
        inventory[3] = book3;
        inventory[4] = book4;
        inventory[5] = book5;
        inventory[6] = book6;
        inventory[7] = book7;
        inventory[8] = book8;
        inventory[9] = book9;
        inventory[10] = book10;
        inventory[11] = book11;
        inventory[12] = book12;
        inventory[13] = book13;
        inventory[14] = book14;
        inventory[15] = book15;
        inventory[16] = book16;
        inventory[17] = book17;
        inventory[18] = book18;
        inventory[19] = book19;

      //User user=new User("mary",1);


        // have my Scanner that will allow user to type their input
        Scanner scanner = new Scanner(System.in);
        //  this is my main loop,while (true) will make infinite loops until user breaks it
        while (true) {
            System.out.println("Welcome to Dunwoody libray how can we help?");
            System.out.println("1) available all books ");
            System.out.println("2) Show Checked out books");
            System.out.println("3) Search by Title or ISBN");
            System.out.println("4) checking out books");
            System.out.println("5) exit");
            int memberChoice = scanner.nextInt();
            switch (memberChoice) {
                case 1:
                    availableBooks(inventory, scanner); // lis available books
                    break;
                case 2:
                    checkedOutBook(inventory, scanner);// checked out books
                    break;
                case 3:
                    searchBooksByTitleorIsbn(inventory, scanner);// search for bopks
                    break;
                case 4:
                    usersChceckedOutBooks(inventory, scanner);// check if a book is checked out
                    break;
                 case 5 :
                 System.exit(0);// exit
                 break;
                default:
                    System.out.println("no option");


            }


        }

    }

    public static void availableBooks(Book[] inventory, Scanner scanner) { // this my method for case 1 display avilable book
        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i].isCheckedOut() != true) {
                System.out.println(inventory[i].getId() + " " + inventory[i].getIsbn() + " " + inventory[i].getTitle());

            }
        }
        System.out.println("do you want to select a book to check out"); // asking user if they want to check out or not
        System.out.println("1) yes ");
        System.out.println("2) no");
        int selectOption = scanner.nextInt(); // add my code  new line
        if (selectOption == 1) {//if yes then they will need this info
            System.out.println("what is your name");
            scanner.nextLine();

            String name = scanner.nextLine();
            // then they will check out the book
            System.out.println("which book do you want?");
            String bookName = scanner.nextLine();
            for (int i = 0; i < inventory.length; i++) {
                if (bookName.equalsIgnoreCase(inventory[i].getTitle())) {

                    // weather the book has been checked out or not( we saying true because the book is checked out)
                    inventory[i].setCheckedOut(true);
                    System.out.println(" your due date is 10 days from today!");
                    inventory[i].setDueDate("your dueDate is 10 days from today!");// this set dueDate when they show check out book.
                }
            }


        }

    }

    public static void checkedOutBook(Book[] inventory, Scanner scanner) { // case 2 Method allow to check in
        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i].isCheckedOut() == true) {
                System.out.println(inventory[i].getId() + " " + inventory[i].getIsbn() + " " +
                        inventory[i].getTitle() + " " + inventory[i].getCheckedOutTo());


            }
        }
        System.out.println("would you like to check in  your books?");
        System.out.println("C) yes");
        System.out.println("X) no");
        scanner.nextLine();
        String checkedInApril = scanner.nextLine();
        if (checkedInApril.equalsIgnoreCase("c")) {
            // using equal sign for sting to print if yes is the answer
        }
        System.out.println("what is the book Id number?");
        int idNumber = scanner.nextInt();
        scanner.nextLine(); //  it will escape the next line
        //check each index to see which id number in the array match with the users id number.
        for (int i = 0; i < inventory.length; i++) {
            if (inventory[i].getId() == idNumber) {// users id number match inventory
                inventory[i].setCheckedOut(false);// because user has return book we have to set it to false
                inventory[i].setCheckedOutTo("");// user returned the book, it is available


            }
        }
    }

             // case 3 method to search for books by title or isbn
            public static void searchBooksByTitleorIsbn(Book[] inventory,Scanner scanner) {
                scanner.nextLine();
                String checkedOut = scanner.nextLine();
                for (int i = 0; i < inventory.length; i++) {
                    Book currentBookInLibrary = inventory[i];
                    if (currentBookInLibrary != null) {
                        System.out.println(currentBookInLibrary.toString());
                    } else if (currentBookInLibrary == null) {

                        System.out.println("no check out book");

                    } else {
                        System.out.println("unauthorized user!");
                    }

                }


            }
              // case 4 method if a specific book is checked out
            public static void  usersChceckedOutBooks(Book[] inventory,Scanner scanner) {
                System.out.println(" which book do you want  please enter title or Isbn?");
                scanner.nextLine();
                String bookTitleIsbn = scanner.nextLine();
                for (int i = 0; i < inventory.length; i++) {
                    //contains is the new method i use that will compare the user input with the isbn at inventory[i] or title
                    if (inventory[i].getIsbn().contains(bookTitleIsbn) || inventory[i].getTitle().contains(bookTitleIsbn)) {
                        System.out.println("the same:" + inventory[i]);

                        if (inventory[i].isCheckedOut()) {
                            System.out.println("checked out");
                        } else {
                            System.out.println("available");
                        }
                    }

                }
            }

        }


