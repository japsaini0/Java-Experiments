package com.bank.loans;

public class Loan
{
    private double loanAmount;

    public Loan(double amount)
    {
        loanAmount = amount;
    }

    public double calculateEMI()
    {

        double rate = 10;
        int time = 12;

        double emi = (loanAmount * rate * time) / 1200;

        return emi;
    }
}