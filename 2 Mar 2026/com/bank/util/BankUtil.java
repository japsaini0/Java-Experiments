package com.bank.util;

import java.util.Random;

public class BankUtil
{
    public static int generateAccountNumber() 
    {

        Random r = new Random();
        return 10000 + r.nextInt(90000);
    }

    public static boolean validateMinimumBalance(double balance)
    {
        if(balance >= 1000)
            return true;
        
        else
            return false;
    }
}