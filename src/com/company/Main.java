package com.company;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        final byte numberOfMonthsInYear = 12;
        final byte Percent = 100;
        int Principal = 0;
        float annualInterest = 0;
        float monthlyInterest = 0;
        byte years;
        int numOfPayments =0;

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Principal ($1k - $1m): ");
             Principal = scanner.nextInt();
            if (Principal >= 1000 && Principal <= 1_000_000)
                break;
            System.out.println("Enter a value between 1000 and 1000000");
        }

        while (true) {
            System.out.print("Annual Interest: ");
            annualInterest = scanner.nextFloat();
            if (annualInterest >=1 && annualInterest<=30 ) {
                monthlyInterest = annualInterest / numberOfMonthsInYear / Percent;
                break;
            }
            System.out.println("Enter a value between 1 and 30");
        }
        while (true) {
            System.out.print("Period (Years): ");
            years = scanner.nextByte();
            if (years >=1 && years<=30){
                numOfPayments = years * numberOfMonthsInYear;
                break;
            }
            System.out.println("Enter a number 1 and 30");
        }

        double mortgage =
                    ((Principal * Math.pow(1 + monthlyInterest, years))
                    /(Math.pow(1 + monthlyInterest,numOfPayments)-1));

        String mortgageFormatted = NumberFormat.getPercentInstance().format(mortgage);

        System.out.println("Mortgage: " +mortgageFormatted);
    }
}
