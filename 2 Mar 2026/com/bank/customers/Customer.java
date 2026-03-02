package com.bank.customers;

import com.bank.accounts.Account;

public class Customer
{
    private int customerId;
    private String name;
    private Account account;

    public Customer(int id, String name)
    {
        customerId = id;
        this.name = name;
    }

    public void linkAccount(Account acc)
    {
        account = acc;
        System.out.println("Account linked to customer");
    }

    public void showDetails() 
    {
        System.out.println("Customer: " + name);
        System.out.println("Account No: " + account.getAccountNumber());
        System.out.println("Balance: " + account.getBalance());
    }
}