package com.lulobank.authorizer.repository.implementation;

import com.lulobank.authorizer.entity.Account;
import com.lulobank.authorizer.entity.Transaction;
import com.lulobank.authorizer.repository.interfaces.ITransactionRepository;
import com.lulobank.authorizer.util.persistence.TransactionPersistence;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

/**
 * Class that represents repository of a transaction
 */
@Repository
public class TransactionRepository implements ITransactionRepository {

    TransactionPersistence transactionPersistence = new TransactionPersistence();

    /**
     * Method to get an transaction by id
     * @param id
     * @return
     */
    @Override
    public Transaction getTransaction(int id) {
        if(transactionPersistence.getTransactions().containsKey(id)){
            return transactionPersistence.getTransactions().get(id);
        }else{
            return null;
        }
    }

    /**
     * Methos that save a transaction
     * @param transaction
     * @return
     */
    @Override
    public Transaction saveTransaction(Transaction transaction) {
        Transaction newTransaction = null;
        if(!transactionPersistence.getTransactions().containsKey(transaction.getId())) {
            transaction.setId(transactionPersistence.getTransactions().size()+1);
            newTransaction = transactionPersistence.getTransactions().put(transactionPersistence.getTransactions().size()+1,transaction);
            return newTransaction;
        }else{
            return newTransaction;
        }
    }
    /**
     * Mathod that get all transactions
     * @return
     */
    @Override
    public List<Transaction> getAll() {
        List<Transaction> transactions = new ArrayList<Transaction>();
        transactionPersistence.getTransactions().forEach((key, tab) -> transactions.add(tab));
        return transactions;
    }
    /**
     * Method that verify whether a transaction exists
     * @param id
     * @return
     */
    @Override
    public boolean existTransactionById(int id) {
        boolean existsTransaction  = false;
        if(transactionPersistence.getTransactions().containsKey(id)){
            existsTransaction = true;
        }
        return  existsTransaction;
    }
}
