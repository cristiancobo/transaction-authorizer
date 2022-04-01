package com.lulobank.authorizer.util.persistence;

import com.lulobank.authorizer.entity.Transaction;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;

public class TransactionPersistence
{

    HashMap<Integer, Transaction> transactions;

    public TransactionPersistence() {
        this.transactions = new HashMap<>();
       // Transaction transaction = new Transaction(1,1,"Carulla",2200);
       //transactions.put(1,transaction);

    }

    public HashMap<Integer, Transaction> getTransactions() {
        return transactions;
    }
}
