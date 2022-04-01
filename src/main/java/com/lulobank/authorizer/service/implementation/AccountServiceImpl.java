package com.lulobank.authorizer.service.implementation;

import com.lulobank.authorizer.controller.dto.specout.AccountSpecOutDto;
import com.lulobank.authorizer.controller.dto.stdin.AccountStdInDto;
import com.lulobank.authorizer.controller.dto.stdout.AccountStdOutDto;
import com.lulobank.authorizer.entity.Account;
import com.lulobank.authorizer.entity.Transaction;
import com.lulobank.authorizer.repository.interfaces.IAccountRepository;
import com.lulobank.authorizer.repository.interfaces.ITransactionRepository;
import com.lulobank.authorizer.service.interfaces.IAccountService;
import com.lulobank.authorizer.service.mapper.IAccountMapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Method that represents service of an account
 */
@Service
public class AccountServiceImpl implements IAccountService {

    private IAccountRepository iAccountRepository;
    private ITransactionRepository iTransactionRepository;

    /**
     * Constructor
     * @param iAccountRepository
     * @param iTransactionRepository
     */
    @Autowired
    public AccountServiceImpl(IAccountRepository iAccountRepository, ITransactionRepository iTransactionRepository) {
        this.iAccountRepository = iAccountRepository;
        this.iTransactionRepository = iTransactionRepository;
    }

    /**
     * Method that get an account by id
     * @param id
     * @return
     */
    @Override
    public AccountStdOutDto getAccount(int id) {
       if(!iAccountRepository.existAccoutById(id)){
       }
       Account account = iAccountRepository.getAccount(id);
       AccountStdOutDto accountStdOutDto = IAccountMapperImpl.INSTANCE.asAccountToAccountStdoutDto(account);
        for (Transaction transaction : account.getTransactions()) {
            accountStdOutDto.addTransaction(transaction);
        }
        return accountStdOutDto;
    }

    /**
     * Method that save an account
     * @param accountStdInDto
     * @return
     */
    @Override
    public AccountSpecOutDto saveAccount(AccountStdInDto accountStdInDto) {
        Account account = IAccountMapperImpl.INSTANCE.asAccountStdInDtotoAccount(accountStdInDto);
        if (accountStdInDto.getTransactionsAccount() != null) {
            for(int idTransaction: accountStdInDto.getTransactionsAccount()) {
                if(iTransactionRepository.existTransactionById(idTransaction)){
                    account.addTransaction(iTransactionRepository.getTransaction(idTransaction));
                }
        }

        }
        AccountSpecOutDto accountSpecOutDto = IAccountMapperImpl.INSTANCE.asAccountToAccountSpecOutDto(account);
        if(!iAccountRepository.existAccoutById(account.getId())){
            iAccountRepository.saveAccount(account);
            return accountSpecOutDto;
        }
        accountSpecOutDto.addViolation(Account.ACCOUNT_ALREADY_INITIALIZED);
        return accountSpecOutDto;

    }

    /**
     * Method that get all accounts
     * @return
     */
    @Override
    public List<AccountStdOutDto> getAll() {
        List<Account> accounts = iAccountRepository.getAll();
        List<AccountStdOutDto> accountStdOutDtos = IAccountMapperImpl.INSTANCE.asAccountListEntitiesToAccountListStdOutDto(accounts);
        for (int i =0 ; i < accountStdOutDtos.size() ; i++){
            accountStdOutDtos.get(i).setTransactionsAccount(accounts.get(i).getTransactions());
        }
        return accountStdOutDtos;
    }
}
