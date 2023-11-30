package com.company.model;



public class BankAccount {
    /**
     * Attributes: account Number an dthe balance
     */
    private int accountNum;
    private double balance;

    public BankAccount(int accountNum, double balance) {
        this.accountNum = accountNum;
        this.balance = balance;
    }

    public int getAccountNum() {
        return accountNum;
    }

    public double getBalance() {
        return balance;
    }

    /**
     * method to add money in the account
     * @param amount  .
     */
    public void depositTo(double amount) {
        balance = getBalance() + amount;
    }

    /**
     *  Method to withdraw money from the account.
     * @param amount .
     */
     public void withdrawTo(double amount){
        balance = getBalance() - amount;
     }

}
