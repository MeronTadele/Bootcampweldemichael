package org.example;

import java.io.FileReader;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        menu();
    }

    public static void menu() { // this is my menu method
        Scanner scanner = new Scanner(System.in);
        Ledger ledger = new Ledger(); // instantiate my Ledger class

        while (true) { // this is infinite loop until user chooses to exit
            System.out.println("Welcome to Mary-Saver Bank");
            System.out.println("A) Deposit ");
            System.out.println("B) Make Payment ");
            System.out.println("C) Ledger ");
            System.out.println("D) Exit ");

            String userInput = scanner.nextLine().toUpperCase();

            // evaluate user input with conditional logic
            switch (userInput.charAt(0)) { // converting from string to char
                case 'A':
                    deposit(scanner, ledger);// deposit method
                    break;
                case 'B':
                    payment(scanner, ledger);// payment method
                    break;
                case 'C':
                    ledger(scanner, ledger);// ledger report method
                    break;
                case 'D':
                    System.exit(0);//Exit the loop and terminate the program
                    break;
                default:
                    System.out.println("invalid");


            }
        }
    }
    // deposit input, parses user data,
    public static void deposit(Scanner scanner, Ledger ledger) {

        System.out.println(" would like to make deposit? ");
        System.out.println("1) yes ");
        System.out.println("2) no ");

        int answer = scanner.nextInt();
        scanner.nextLine();// consume newline
        if (answer == 1) {
            try {
               //gather transaction details from user
                System.out.print("Enter vendor name:");
                String vendor = scanner.nextLine();
                System.out.print("Enter your deposit description:");
                String description = scanner.nextLine();
                System.out.print("Enter your deposit amount:");
                double amount = Double.parseDouble(scanner.nextLine()); // parse string to double
                LocalDate today = LocalDate.now(); // i declare my variable today use current date
                System.out.println(today);
                LocalTime now = LocalTime.now();// current time
                // persist transaction
                System.out.println(" Deposit successful " + now);
                ledger.addDeposit(new Transaction(LocalDate.now(), LocalTime.now(), description, vendor, amount));

            } catch (NumberFormatException ex) {
                System.out.println("invalid");
            }
            if (answer == 2) ;

            System.out.println();

        }

    }
     // handles payment input and store a negative transaction amount
    public static void payment(Scanner scanner, Ledger leger) {
        System.out.println(" would like to make payment? ");
        System.out.println("1) yes ");
        System.out.println("2) no ");

        int answer = scanner.nextInt();
        scanner.nextLine();
        if (answer == 1) {
            try {
             // collect payment details
                System.out.print("Enter  vendor name:");
                String vendor = scanner.nextLine();
                System.out.print("Enter your payment description:");
                String description = scanner.nextLine();
                System.out.print("Enter your payment amount:");
                double amount = Double.parseDouble(scanner.nextLine());
                amount *= -1; // store payments as a negative values
                LocalDate today = LocalDate.now();
                LocalTime now = LocalTime.now();
                System.out.println("Paid successfully!" + " " + today);
                System.out.println(now);
                leger.makePayment(new Transaction(LocalDate.now(), LocalTime.now(), description, vendor, amount));

            } catch (NumberFormatException ex) {
                System.out.println("invalid");
            }


        }


    }
    // this method provides filtering / report functionality
    public static void ledger(Scanner scanner, Ledger ladger) {
        System.out.println("pick your option");
        System.out.println("A) display all entries");
        System.out.println("B) display only deposits");
        System.out.println("C) display only payments");
        System.out.println("D) show me reports");
        System.out.println("E) Exit");
        List<Transaction> transactions = TransactionFileManager.readFile(); // load transactions
        String userchoice = scanner.nextLine().toUpperCase();
        try {
            switch (userchoice.charAt(0)) {//converting to char

                case 'A':
                    System.out.println("date|time|description|vendor|amount");
                    for (Transaction transaction : transactions) {
                        System.out.println(transaction.toString());
                    }
                    break;
                case 'B':
                    System.out.println("date|time|description|vendor|amount");
                    for (Transaction transaction : transactions) {
                        if (transaction.getAmount() > 0) {
                            System.out.println(transaction.toString());
                        }
                    }
                    break;
                case 'C':
                    System.out.println("date|time|description|vendor|amount");
                    for (Transaction transaction : transactions) {
                        if (transaction.getAmount() < 0) {
                            System.out.println(transaction.toString());
                        }
                    }
                    break;
                case 'D': // refactor recommendation and report logic
                    boolean searchDates = true;
                    while (searchDates) {
                        System.out.println("How would you like to search");
                        System.out.println("1) Month to Date");
                        System.out.println("2) previous Month");
                        System.out.println("3) Year To Date");
                        System.out.println("4) previous Year");
                        System.out.println("5) Search by Vendor");
                        System.out.println("6) Search by Description");
                        System.out.println("7) Search by Amount");
                        System.out.println("0) Back");

                        int visit = scanner.nextInt();
                        scanner.nextLine();
                        LocalDate today = LocalDate.now();
                        for (Transaction transaction : transactions) {
                            LocalDate date = transaction.getDate();

                            if (visit == 1) {
                                if (date.getMonth() == today.getMonth() && date.getYear() == today.getYear()) {
                                    System.out.println(transaction.toString());
                                }
                            }
                            if (visit == 2) {//this is class
                                if (date.getMonth() == today.getMonth().minus(1) && date.getYear() == today.getYear()) {
                                    System.out.println(transaction.toString());
                                }
                            }
                            if (visit == 3) {
                                if (date.getYear() == today.getYear()) {
                                    System.out.println(transaction.toString());
                                }
                            }
                            if (visit == 4) {// this is int
                                if (date.getYear() == today.getYear() - 1) {
                                    System.out.println(transaction.toString());
                                }
                            }

                            if (visit == 5) {
                                int vendorName = 0;
                                System.out.println(" which vendor are you searching for?");

                                String byName = scanner.nextLine();
                                boolean searchByVendor = false;

                                for (int i = 0; i < transactions.size(); i++) {
                                    //Transaction transaction=transactions.get(i);

                                    if (byName.equalsIgnoreCase(transactions.get(i).getVendor())) {
                                        System.out.println(transaction.toString());
                                        searchByVendor = true;
                                        vendorName = i;

                                    } else if (transactions.size() == (i + 1) && !searchByVendor) {// i didn't have a break till i initiate my else if statement
                                        System.out.println(" invaild input; please try again! ");
                                    }

                                }
                                break;
                            }
                            if (visit == 6) {//todo not showing result do loop
                                System.out.println("Enter your transaction Description please.");
                                String details = scanner.nextLine();
                                boolean searchByDescription = false;
                                for (int i = 0; i < transactions.size(); i++) {
                                    if (details.equalsIgnoreCase(transactions.get(i).getDescription())) {
                                        System.out.println(transactions.get(i).toString());
                                        searchByDescription = true;
                                    } else if (transactions.size() == (i + 1) && !searchByDescription) {
                                        System.out.println(" invaild input; try again!");

                                    }

                                }
                                break;
                            }
                            if (visit == 7) {
                                System.out.println("1) for deposit");
                                System.out.println("2) for payment");
                                int pay = Integer.parseInt(scanner.nextLine());
                                boolean entry = false;

                                if (pay == 1) {
                                    System.out.println("Enter your amount!");
                                    String depositByUser = scanner.nextLine();
                                    double amountEnter = Double.parseDouble(depositByUser);
                                    for (int i = 0; i < transactions.size(); i++) {
                                        double userAmount = transactions.get(i).getAmount();

                                        entry = true;
                                        if (userAmount == amountEnter) {
                                            System.out.println(transactions.get(i).toString());
                                        }
                                        if (transactions.size() == i + 1 && !entry) { // if user input  was not found in the list then printout invalid
                                            System.out.println(" invalid transaction");
                                        }
                                    }
                                } else if (pay == 2) {
                                    System.out.println("Enter your amount!");
                                    String paymentByUser = scanner.nextLine();
                                    double amountEnter = Double.parseDouble(paymentByUser) * -1;
                                    for (int i = 0; i < transactions.size(); i++) {
                                        double userAmount = transactions.get(i).getAmount();
                                        if (userAmount == amountEnter)
                                            System.out.println(transactions.get(i).toString());
                                        entry = true;

                                        if (transactions.size() == i + 1 && !entry) { // if user input  was not found in the list then printout invalid
                                            System.out.println(" invalid transaction");
                                        }
                                    }


                                }
                                break;


                            }


                        }


                        if (visit == 0) {
                            searchDates = false;
                        }
                    }


                    break;
                case 'E':
                    return;
                default:
                    break;


            }


        } catch (StringIndexOutOfBoundsException ex) {
            System.out.println(" Error!!! ");
        }
    }
}
