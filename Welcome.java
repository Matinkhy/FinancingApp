package com.mycompany.financingapp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Welcome {

    public static void Welcome() {
        if (FirstTime()) {
            File file = new File("Documents\\NetBeansProjects\\FinancingInfo.txt");
            Balance.balance = Balance.budget = Balance.transactionsNum = 0;
        } else {
            try (BufferedReader reader = new BufferedReader(new FileReader("Documents\\NetBeansProjects\\FinancingInfo.txt"))) {
                Balance.balance = Long.parseLong(reader.readLine());
                Balance.budget = Long.parseLong(reader.readLine());
                Balance.transactionsNum = Long.parseLong(reader.readLine());
            } catch (IOException e) {
            }
        }
    }

    public static void prompt() {
        System.out.println("What do you want to do now");
        System.out.println("0) Check balance");
        System.out.println("1) Deposit");
        System.out.println("2) Withdraw");
        System.out.println("3) Set a budget");
        System.out.println("4) See your budget");
        System.out.println("5) Get your previous 10 transactions");
        System.out.println("9) Exit");
    
    }

    public static boolean FirstTime() {
        File file = new File("Documents\\NetBeansProjects\\FinancingInfo.txt");
        return file.exists();
    }

}
