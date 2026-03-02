package com.bank.accounts;

public class Account
{
    protected int accountNumber;
    protected double balance;

    public Account(int accountNumber, double balance)
    {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void deposit(double amount)
    {
        balance += amount;
        System.out.println("Deposited: " + amount);
    }

    public void withdraw(double amount)
    {
        if(balance >= amount)
        {
            balance -= amount;

            System.out.println("Withdrawn: " + amount);
        }

        else
        {
            System.out.println("Insufficient Balance");
        }
    }

    public double getBalance()
    {
        return balance;
    }

    public int getAccountNumber()
    {
        return accountNumber;
    }
}