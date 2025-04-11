package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class Calculator2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //ask for input to user
        System.out.println("how much do you want to deposit?");
        double initialDeposit = scanner.nextDouble();
        System.out.println("enter your interest rate");
        double annualRate = scanner.nextDouble();
        System.out.println("enter for how long you need it");
        double years= scanner.nextDouble();
        //convert to decimal
        double daysPerYear =365;
        double rateDecimal= annualRate / 100;
        // calculate using my formula FV = P(1 + r/365)^(365*t)
        double futureValue = initialDeposit * Math.pow(1 +(rateDecimal / 365), daysPerYear * years);
        System.out.printf("if you deposit $%.2f in a CD that earns %.2f%% interest and in %.0f years in \n",initialDeposit,annualRate,daysPerYear);
        //total interest using a formula FutureValue - initialDeposit
        double totalInterest = futureValue - initialDeposit;
        System.out.printf("your cd ending balance will be $%.2f total interest earned is $%.2f \n", futureValue,totalInterest);




    }
}