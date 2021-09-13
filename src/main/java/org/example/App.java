package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

/*
 *  UCF COP3330 Fall 2021 Assignment 10 Solution
 *  Copyright 2021 Tyler Coleman
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println("Self Checkout - Press Q when done to check out.");
        Scanner in = new Scanner(System.in);
        int i = 1;
        List<String> prices = new ArrayList<>();
        List<String> quantities = new ArrayList<>();
        while(true) {
            System.out.println("Enter the price of item " + i + ":");
            String price = in.nextLine();
            if(price.equals("")|price.equals("Q")|price.equals("q")){
                break;
            }
            else{
                prices.add(price);
            }
            System.out.println("Enter the quantity of item " + i + ":");
            String quantity = in.nextLine();
            if(quantity.equals("")|quantity.equals("Q")|quantity.equals("q")){
                quantities.add("0");
                break;
            }
            else{
                quantities.add(quantity);
            }
            i = i + 1;
        }
        double subtotal = 0.00;
        double taxRate = 0.055;
        double tax, total, price, quantity;
        for(int x = 0; x < prices.toArray().length; x++){
            String priceS = prices.get(x);
            String quantityS = quantities.get(x);
            price = parseInt(priceS);
            quantity = parseInt(quantityS);
            subtotal = subtotal + (price * quantity);
        }
        tax = subtotal * taxRate;
        total = subtotal + tax;
        System.out.printf("Subtotal: $%.02f\nTax: $%.02f\nTotal: $%.02f\nThanks for shopping!", subtotal, tax, total);
    }
}
