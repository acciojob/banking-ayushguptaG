package com.driver;

public class Main {
    public static void main(String[] args) {

        SavingsAccount acc= new SavingsAccount("ayush", 10000, 50000,5);

        acc.deposit(1000);
        System.out.println(acc.getBalance());

    }
}
