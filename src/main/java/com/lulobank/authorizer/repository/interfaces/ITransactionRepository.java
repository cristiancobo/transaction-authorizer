package com.lulobank.authorizer.repository.interfaces;

import com.lulobank.authorizer.entity.Account;
import com.lulobank.authorizer.entity.Transaction;

import java.util.List;

public interface ITransactionRepository {

    public Transaction getTransaction(int id);

    public Transaction saveTransaction(Transaction transaction);

    public List<Transaction> getAll();

    public boolean existTransactionById(int id);
}
