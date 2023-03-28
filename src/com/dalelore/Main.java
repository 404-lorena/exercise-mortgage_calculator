package com.dalelore;

// Need imports!
import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    // declare constants
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        int principal = 0;
        float monthlyInterest = 0;
        int numberOfPayments = 0;

        // User input
        Scanner scanner = new Scanner(System.in);

        // Prompts
        while(true){
            System.out.print("Principal ($1K - $1M): ");
            principal = scanner.nextInt();
            if(principal >= 1000 && principal <= 1_000_000)
                break;
            System.out.println("Enter a number between 1,000 and 1,000,000");
        }

        while(true){
            System.out.print("Annual Interest Rate: ");
            float annualInterest = scanner.nextFloat();
            if(annualInterest>= 1 && annualInterest <= 30){
                monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;
                break;
            }
            System.out.println("Enter a value between 1 and 30");
        }

        while(true) {
            System.out.print("Period (in years): ");
            byte years = scanner.nextByte();
            if (years >= 1 && years <= 30) {
                numberOfPayments = years * MONTHS_IN_YEAR;
                break;
            }
        }
        // Calculating mortage payment formula
        /**     M = P [ i(1 + i)^n ] / [ (1 + i)^n – 1].
                M = Total monthly payment.
                P = The total amount of your loan.
                I = Your interest rate, as a monthly percentage.
                N = The total amount of months in your timeline for paying off your mortgage.
         **/

        double mortgage = principal * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments) / (Math.pow(1 + monthlyInterest, numberOfPayments)-1));

        String mortageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);

        System.out.println("Mortage: " + mortageFormatted);
    }
}
