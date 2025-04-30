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

    public static void menu() {
        Scanner scanner = new Scanner(System.in);
        Ledger ledger = new Ledger();

        while (true) {
            System.out.println("Welcome to Saver Bank");
            System.out.println("A) Deposit ");
            System.out.println("B) Make Payment ");
            System.out.println("C) Ledger ");
            System.out.println("D) Exit ");

            String userInput = scanner.nextLine().toUpperCase();

            switch (userInput.charAt(0)) { // converting from string to char
                case 'A':
                    deposit(scanner, ledger);
                    break;
                case 'B':
                    payment(scanner, ledger);
                    break;
                case 'C':
                    ledger(scanner, ledger);
                    break;
                case 'D':
                    break;
                default:


            }
        }
    }


    public static void deposit(Scanner scanner, Ledger ledger) {

        System.out.println(" would like to make deposit? ");
        System.out.println("1) yes ");
        System.out.println("2) no ");

        int answer = scanner.nextInt();
        scanner.nextLine();
        if (answer == 1) {
            try {

                System.out.println("What is the vendor name?");
                String vendor = scanner.nextLine();
                System.out.println("Enter your deposit description");
                String description = scanner.nextLine();
                System.out.println("Enter your deposit amount");
                double amount = Double.parseDouble(scanner.nextLine());
                LocalDate today = LocalDate.now();
                System.out.println(today);
                LocalTime now = LocalTime.now();
                System.out.println(now);
                ledger.addDeposit(new Transaction(LocalDate.now(), LocalTime.now(), description, vendor, amount));

            } catch (NumberFormatException ex) {
                System.out.println("invalid");
            }
            if (answer == 2) ;

            System.out.println();

        }

    }

    public static void payment(Scanner scanner, Ledger leger) {
        System.out.println(" would like to make payment? ");
        System.out.println("1) yes ");
        System.out.println("2) no ");

        int answer = scanner.nextInt();
        scanner.nextLine();
        if (answer == 1) {
            try {

                System.out.println("What is the vendor name?");
                String vendor = scanner.nextLine();
                System.out.println("Enter your payment description");
                String description = scanner.nextLine();
                System.out.println("Enter your payment amount");
                double amount = Double.parseDouble(scanner.nextLine());
                amount *= -1;
                LocalDate today = LocalDate.now();
                System.out.println(today);
                LocalTime now = LocalTime.now();
                System.out.println(now);
                leger.makePayment(new Transaction(LocalDate.now(), LocalTime.now(), description, vendor, amount));

            } catch (NumberFormatException ex) {
                System.out.println("invalid");
            }


        }


    }

    public static void ledger(Scanner scanner, Ledger ladger) {
        System.out.println("pick your option");
        System.out.println("A) display all entries");
        System.out.println("B) display only deposits");
        System.out.println("C) display only payments");
        System.out.println("D) show me reports");
        System.out.println("E) Exit");
        List<Transaction> transactions = TransactionFileManager.readFile();
        String userchoice = scanner.nextLine().toUpperCase();
        try {
            switch (userchoice.charAt(0)) {//converting to char

                case 'A':
                    for (Transaction transaction : transactions) {
                        System.out.println(transaction.toString());
                    }
                    break;
                case 'B':
                    for (Transaction transaction : transactions) {
                        if (transaction.getAmount() > 0) {
                            System.out.println(transaction.toString());
                        }
                    }
                    break;
                case 'C':
                    for (Transaction transaction : transactions) {
                        if (transaction.getAmount() < 0) {
                            System.out.println(transaction.toString());
                        }
                    }
                    break;
                case 'D':
                    boolean searchDates = true;
                    while (searchDates) {
                        System.out.println("How would you like to search");
                        System.out.println("1) Month to Date");
                        System.out.println("2) previous Month");
                        System.out.println("3) Year To Date");
                        System.out.println("4) previous Year");
                        System.out.println("5) Search by Vendor");
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
                                System.out.println(" which vendor are you searching for?");

                                String byName = scanner.nextLine();
                                boolean searchByVendor = false;

                                for (int i = 0; i < transactions.size(); i++) {

                                    if (byName.equalsIgnoreCase(transactions.get(i).getVendor())) {
                                        System.out.println(transaction.toString());

                                    } else if (transactions.size() == (i + 1) && !searchByVendor) {
                                        System.out.println(" invaild input; please try again! ");
                                    }
                                    break;
                                }
                            }

                            if (visit == 0) {
                                searchDates = false;
                            }
                        }
                        }

                            break;
                            case 'E':
                                return;
                            default:
                                break;


                    }



        }catch(StringIndexOutOfBoundsException ex){
            System.out.println(" Error!!! ");
        }
    }
}
