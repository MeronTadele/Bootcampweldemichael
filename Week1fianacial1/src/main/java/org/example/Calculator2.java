package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class Calculator2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //ask for input to user
        System.out.println("how much do you want to deposit?");
        double initialDeposit = scanner.nextDouble(); // this is my (P)
        System.out.println("enter your interest rate");
        double annualRate = scanner.nextDouble(); // this is my (r)
        System.out.println("enter for how long you need it");
        double years= scanner.nextDouble(); // this is my (t)
        //convert to decimal
        double daysPerYear =365;
        double rateDecimal= annualRate / 100;
        // calculate using my formula FV = P(1 + r/365)^(365*t)
        double futureValue = initialDeposit * Math.pow(1 +(rateDecimal / 365), daysPerYear * years);
        // interesting piece i used is %.2f it will give me 2 digit after decimal
        //%.0f it will round it to the nearest whole number and  %.2f%% it will print % sign
        System.out.printf("if you deposit $%.2f in a CD that earns %.2f%% interest and in %.0f years in \n",initialDeposit,annualRate,daysPerYear);
        //total interest using a formula FutureValue - initialDeposit
        double totalInterest = futureValue - initialDeposit;
        System.out.printf("your cd ending balance will be $%.2f total interest earned is $%.2f \n", futureValue,totalInterest);




    }
}