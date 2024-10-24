package com.mycompany.financingapp;

import java.util.Scanner;

public class FinancingApp {

    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        scan.useDelimiter("\n");
        System.out.println("Hello, welcome to your financing app");
        System.out.println("Remember, whenever you wanna exit you can just type exit in the output");
        Welcome.Welcome();
        while (true) {
            Welcome.prompt();
            String response = scan.next();
            switch (response) {
                case "0" ->
                    Balance.checkBalance();
                case "1" -> {
                    System.out.println("How much do you want to deposit?");
                    long amount = scan.nextLong();
                    Balance.deposit(amount);
                }
                case "2" -> {
                    System.out.println("How much do you want to withdraw?");
                    long amount = scan.nextLong();
                    Balance.withdraw(amount);
                }
                case "3" -> {
                    System.out.println("How much do you want as your budget?");
                    long amount = scan.nextLong();
                    Balance.setBudget(amount);

                }
                case "4" ->
                    Balance.getBudget();

                case "5" ->
                    Balance.getTransactions();
                case "9" -> {
                    System.out.println("Thank you for using this program");
                    System.exit(0);
                }
                case "exit" -> {
                    System.out.println("Thank you for using this program");
                    System.exit(0);
                }
            }
        }
    }
}
