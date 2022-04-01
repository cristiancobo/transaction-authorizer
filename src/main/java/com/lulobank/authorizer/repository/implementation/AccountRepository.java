package com.lulobank.authorizer.repository.implementation;

import com.lulobank.authorizer.entity.Account;
import com.lulobank.authorizer.repository.interfaces.IAccountRepository;
import com.lulobank.authorizer.util.persistence.AccountPersistence;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Class that represents repository of an account
 */
@Repository
public class AccountRepository implements IAccountRepository

{

   AccountPersistence accountPersistence = new AccountPersistence();

    /**
     * Method to get an account by id
     * @param id
     * @return
     */
    @Override
    public Account getAccount(int id) {
        if(accountPersistence.getAccounts().containsKey(id)){
            return accountPersistence.getAccounts().get(id);
        }else{
            return null;
        }
    }

    /**
     * Methos that save an account
     * @param account
     * @return
     */
    @Override
    public Account saveAccount(Account account) {
        Account newAccount = null;
        if(!accountPersistence.getAccounts().containsKey(account.getId())) {
            newAccount = accountPersistence.getAccounts().put(account.getId(),account);
            return newAccount;
        }else{
            return newAccount;
        }
    }

    /**
     * Mathod that get all accounts
     * @return
     */
    @Override
    public List<Account> getAll() {
        List<Account> accounts = new ArrayList<Account>();
        accountPersistence.getAccounts().forEach((key, tab) -> accounts.add(tab));
        return accounts;
    }

    /**
     * Method that verify whether an account exists
     * @param id
     * @return
     */
    @Override
    public boolean existAccoutById(int id) {
        boolean existsAccount  = false;
        if(accountPersistence.getAccounts().containsKey(id)){
            existsAccount = true;
        }
        return  existsAccount;
    }
}
