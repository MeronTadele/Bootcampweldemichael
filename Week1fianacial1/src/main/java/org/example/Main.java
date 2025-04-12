package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // asking user to give me input for P,R,N
        System.out.println("how much do you want to invest?");
        double investedMoney = scanner.nextDouble(); // This is my P ( loan amount)
        System.out.println("how much is your annual rate(in %)");
        double interestRate = scanner.nextDouble();  // This is my R ( annual interest rate)
        System.out.println("for how long do you want your loan (in years):");
        double loanLength = scanner.nextDouble(); // This is my N (loan length)
        // calculating my monthly interest rate in decimal
        double monthlyRate = interestRate / 12 / 100;
        //my total number in monthly
        double numberOfMonthly = loanLength * 12;

        //monthly payment calculation P[r(1+r)^n] / [(1+r)^n-1]
        double monthlyPayment= investedMoney * (Math.abs(monthlyRate*Math.pow(1+monthlyRate,numberOfMonthly))
                / Math.abs(Math.pow(1+monthlyRate,numberOfMonthly)-1));
        // total interest paid
        double totalInterest = (monthlyPayment * numberOfMonthly) - investedMoney;
        //Souf in formatted results

        System.out.printf("your investment of $%.2f at  %.2f%% annual interest for  monthly payment with total interest of %.0f year in:\n",investedMoney,interestRate,loanLength);
        System.out.printf("Monthly payment:$%.2f \n",monthlyPayment);
        System.out.printf("total interest paid: $%.2f",totalInterest);



    }


    }