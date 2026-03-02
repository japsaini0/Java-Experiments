package com.bank;

import com.bank.accounts.*;
import com.bank.customers.*;
import static com.bank.util.BankUtil.*;

public class BankApplication
{
    public static void main(String[] args)
    {
        int accNo = generateAccountNumber();

        SavingsAccount acc = new SavingsAccount(accNo, 5000, 5);

        Customer c1 = new Customer(1,"Japjit");

        c1.linkAccount(acc);

        acc.deposit(9999);
        acc.withdraw(2727);

        System.out.println("Interest = " + acc.calculateInterest());
    }
}