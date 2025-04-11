package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // first thing to code for scanner step 1
        Scanner scanner = new Scanner(System.in);
        System.out.println("what is your number?");
        // second step declare variable
        Double firstNumber = scanner.nextDouble();

        System.out.println("second number pls?");
        Double secondNumber = scanner.nextDouble();


        System.out.println("choose an operation:");
        System.out.println("(a), Add");
        System.out.println("(b),Sub");
        System.out.println("(c),Multi");
        System.out.println("(d), Divide");
        System.out.println("please select an option:");
        // using scanner.next() will give option to type my choice
        String option = scanner.next();
        // this is line is important because it will show if we adding or sub e.t.c
        //double result = firstNumber + secondNumber;
        // this perform how is will print
        switch (option) {
            case "a": {
                double result = firstNumber + secondNumber;
                System.out.println("Result:" + (int) result);
            }
            break;
            case "b": {
                double result = firstNumber - secondNumber;
                System.out.println("Result:" +(int) result);
            }
            break;
            case "c": {
                double result = firstNumber * secondNumber;
                System.out.println("Result:" + (int)result);
            }
            break;
            case "d": {
                double result = firstNumber / secondNumber;
                System.out.println("Result:" +(int) result);
                break;
            }
            default: {
                System.out.println("we don't have option");
                break;
            }


        }
    }

}