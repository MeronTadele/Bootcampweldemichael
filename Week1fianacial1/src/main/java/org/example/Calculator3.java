package org.example;

import java.util.Scanner;

public class Calculator3 {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        System.out.println("How much is your monthly payout amount?");
        double monthlyPayOut = scanner.nextDouble(); // This is my (PMT)
        System.out.println("for how long do you want to pay ?");
        double paymentLength = scanner.nextDouble(); // This is my (n)
        System.out.println("How much is your monthly interest rate ?");
        double monthlyInterestRate = scanner.nextDouble(); // This is my (r)

        // converting it to decimal this is my formula
        double annualInterestDecimal = monthlyInterestRate / 12/ 100;
        // number of years to pay out multiplied by 12
        double yearsPayout = paymentLength * 12;
        // using my formula I will calculate the present value (PV) of the annuity  PV = PMT × [(1 - (1 + r)^(-n)) / r]
        double presentValue = monthlyPayOut * ((1-Math.pow(1+annualInterestDecimal,-yearsPayout)) / annualInterestDecimal);
        // using format print result
        // one interesting piece of code I find is that %.1f%% will display the exact %.
        System.out.printf("To fund an annuity that pays $%.2f monthly for %.0f years and earn an expected %.1f%% interest \n"
        ,monthlyPayOut, paymentLength, monthlyInterestRate);
        System.out.printf(",you would need to invest $%.2f now!",presentValue);

    }
}
