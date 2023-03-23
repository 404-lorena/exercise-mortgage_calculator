package com.dalelore;

// Need imports!
import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    // declare constants
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        // User input
        Scanner scanner = new Scanner(System.in);

        // Prompts
        System.out.print("Principal: ");
        int principal = scanner.nextInt();

        System.out.print("Annual Interest Rate: ");
        float annualInterest = scanner.nextFloat();
        float monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;

        System.out.print("Period (in years): ");
        byte years = scanner.nextByte();
        int numerOfPayments = years * MONTHS_IN_YEAR;

        // Calculating mortage payment formula
        /**     M = P [ i(1 + i)^n ] / [ (1 + i)^n – 1].
                M = Total monthly payment.
                P = The total amount of your loan.
                I = Your interest rate, as a monthly percentage.
                N = The total amount of months in your timeline for paying off your mortgage.
         **/

        double mortgage = principal * (monthlyInterest * Math.pow(1 + monthlyInterest, numerOfPayments) / (Math.pow(1 + monthlyInterest, numerOfPayments)-1));

        String mortageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);

        System.out.println("Mortage: " + mortageFormatted);
    }
}
