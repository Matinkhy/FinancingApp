package com.mycompany.financingapp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Balance {

    public static Scanner scan = new Scanner(System.in);

    static long balance;
    static long transactionsNum;
    static long budget;
    static String filepath = "Documents\\NetBeansProjects\\FinancingInfo.txt";

    public static void deposit(long amount) {
        if (amount < 1) {
            System.out.println("Deposit was not done, you need to deposit a positive amount");
        } else {
            balance += amount;
            System.out.println("(Optional) Why did you deposit? (Salary, loan, etc.)");//This is used for the transactions
            String reason = scan.next();
            RecordTransaction(reason, amount, 'd');
        }
    }

    public static void withdraw(long amount) {
        if (amount > balance) {
            System.out.println("You can withdraw, you only have " + balance);
        } else {
            balance -= amount;
            System.out.println("(Optional) Why did you deposit? (purchase, pay loan, etc.)");//This is used for the transactions
            String reason = scan.next();
            RecordTransaction(reason, amount, 'w');
        }
    }

    public static void setBudget(long amount) {
        budget = amount;
    }

    public static long getBudget() {
        return budget;
    }

    public static void checkBalance() {
        System.out.println("You have " + balance + " available");
    }

    public static void getTransactions() {
        List<String> transactions = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            String line;
            List<String> allTransactions = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                reader.readLine();
            }
            while ((line = reader.readLine()) != null) {
                allTransactions.add(line);
            }

            int start = Math.max(0, allTransactions.size() - 10);
            for (int i = start; i < allTransactions.size(); i++) {
                transactions.add(allTransactions.get(i));
            }
        } catch (IOException e) {
        }
        for (String transaction : transactions) {
            System.out.println(transaction);
        }

    }

    public static void RecordTransaction(String reason, long amount, char action) {

        if (action == 'd') { // deposit
            reason = "deposited - " + reason;
        } else if (action == 'w') { //withdrawal
            reason = "withdrew - " + reason;
        }
        try (FileWriter fw = new FileWriter(filepath, true)) {
            fw.write(amount + reason + System.lineSeparator());
            System.out.println("Reason added to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }
        transactionsNum++;
    }

}
