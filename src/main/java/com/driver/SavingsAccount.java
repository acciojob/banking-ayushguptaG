package com.driver;

import java.sql.SQLOutput;

public class SavingsAccount extends BankAccount{
    private double rate;
    private double maxWithdrawalLimit;

    public SavingsAccount(String name, double balance, double maxWithdrawalLimit, double rate) {
        // minimum balance is 0 by default
        super(name,balance, 0);
        this.maxWithdrawalLimit= maxWithdrawalLimit;
        this.rate= rate;
    }

    public double getRate() {
        return rate;
    }

    public double getMaxWithdrawalLimit() {
        return maxWithdrawalLimit;
    }

    public void withdraw(double amount) throws Exception {
        // Might throw the following errors:
        // 1. "Maximum Withdraw Limit Exceed" : If the amount exceeds maximum withdrawal limit
        // 2. "Insufficient Balance" : If the amount exceeds balance
        try {
            if (amount > maxWithdrawalLimit) {
                throw new Exception("Maximum Withdraw Limit Exceed");
            } else if (amount > getBalance()) {
                throw new Exception("Insufficient Balance");
            } else {
                double balance = getBalance();
                balance -= amount;
                setBalance(balance);
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    public double getSimpleInterest(int years){
        // Return the final amount considering that bank gives simple interest on current amount
        double si= (getBalance()*rate*years)/100;

        return si;
    }

    public double getCompoundInterest(int times, int years){
        // Return the final amount considering that bank gives compound interest on current amount given times per year
        double ci= getBalance()*Math.pow((1+rate/100), years);

        return ci;
    }

}
