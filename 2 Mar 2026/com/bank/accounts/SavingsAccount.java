package com.bank.accounts;

public class SavingsAccount extends Account
{
    double interestRate;

    public SavingsAccount(int accNo, double bal, double rate)
    {
        super(accNo, bal);
        interestRate = rate;
    }

    public double calculateInterest()
    {
        return balance * interestRate / 100;
    }
}