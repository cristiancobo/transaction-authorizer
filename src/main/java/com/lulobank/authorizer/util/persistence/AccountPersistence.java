package com.lulobank.authorizer.util.persistence;
import com.lulobank.authorizer.entity.Account;
import com.lulobank.authorizer.entity.Transaction;

import java.util.HashMap;

public class AccountPersistence {

    HashMap<Integer, Account> accounts;

    public AccountPersistence() {
        this.accounts = new HashMap<Integer,Account>();
        Account account = new Account(true,3400);
        Transaction transaction1 = new Transaction(1,1,"Carulla",2200);
        Transaction transaction2 = new Transaction(1,1,"Carulla",600);
        Transaction transaction3 = new Transaction(1,1,"Carulla",2400);
        Transaction transaction4 = new Transaction(1,1,"Carulla",2500);
        account.setId(1);
       // account.addTransaction(transaction1);
       // account.addTransaction(transaction2);
        //account.addTransaction(transaction3);
        //account.addTransaction(transaction4);
        accounts.put(1,account);

    }

    public HashMap<Integer, Account> getAccounts() {
        return accounts;
    }
}
