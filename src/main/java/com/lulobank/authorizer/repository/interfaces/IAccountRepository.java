package com.lulobank.authorizer.repository.interfaces;

import com.lulobank.authorizer.entity.Account;

import java.util.List;

public interface IAccountRepository {

    public Account getAccount(int id);

    public Account saveAccount(Account account);

    public List<Account> getAll();

    public boolean existAccoutById(int id);
}
