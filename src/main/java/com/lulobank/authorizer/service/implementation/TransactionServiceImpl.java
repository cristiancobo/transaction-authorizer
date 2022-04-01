package com.lulobank.authorizer.service.implementation;

import com.lulobank.authorizer.controller.dto.specout.AccountSpecOutDto;
import com.lulobank.authorizer.controller.dto.stdin.TransactionStdInDto;
import com.lulobank.authorizer.controller.dto.stdout.AccountStdOutDto;
import com.lulobank.authorizer.controller.dto.stdout.TransactionStdOutDto;
import com.lulobank.authorizer.entity.Account;
import com.lulobank.authorizer.entity.Transaction;
import com.lulobank.authorizer.repository.interfaces.IAccountRepository;
import com.lulobank.authorizer.repository.interfaces.ITransactionRepository;
import com.lulobank.authorizer.service.interfaces.ITransactionService;
import com.lulobank.authorizer.service.mapper.ITransactionMapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Class that represents service of a transaction
 */
@Service
public class TransactionServiceImpl implements ITransactionService {

    ITransactionRepository iTransactionRepository;
    IAccountRepository iAccountRepository;

    /**
     * Constructor
     * @param iTransactionRepository
     * @param iAccountRepository
     */
    @Autowired
    public TransactionServiceImpl(ITransactionRepository iTransactionRepository, IAccountRepository iAccountRepository) {
        this.iTransactionRepository = iTransactionRepository;
        this.iAccountRepository = iAccountRepository;
    }

    /**
     * Method that get a transaction by id
     * @param id
     * @return
     */
    @Override
    public TransactionStdOutDto getTransaction(int id) {
        if(!iTransactionRepository.existTransactionById(id)){
        }
       Transaction transaction = iTransactionRepository.getTransaction(id);
        TransactionStdOutDto transactionStdOutDto = ITransactionMapperImpl.INSTANCE.asTransactionToTransactionStdoutDto(transaction);
        return transactionStdOutDto;
    }

    /**
     * Method that save a transaction
     * @param transactionStdInDto
     * @return
     */
    @Override
    public AccountSpecOutDto saveTransaction(TransactionStdInDto transactionStdInDto) {
        Transaction transaction = ITransactionMapperImpl.INSTANCE.asTransactionStdInDtoToTransaction(transactionStdInDto);
        AccountSpecOutDto accountSpecOutDto =  new AccountSpecOutDto();;
        boolean existsAccount = iAccountRepository.existAccoutById(transactionStdInDto.getAccountId());
        if(existsAccount){
            if(iAccountRepository.getAccount(transactionStdInDto.getAccountId()).getActiveCard()){
                if(iAccountRepository.getAccount(transactionStdInDto.getAccountId()).getAvailableLimit()-transactionStdInDto.getAmount()>=0){
                    if(iAccountRepository.getAccount(transactionStdInDto.getAccountId()).getTransactions().size()>=3){
                        Transaction toCompareTransaction =iAccountRepository.getAccount(transactionStdInDto.getAccountId()).getTransactions().get(iAccountRepository.getAccount(transactionStdInDto.getAccountId()).getTransactions().size()-3);
                        if(transaction.isRejected(toCompareTransaction.getTime())){
                            accountSpecOutDto.addViolation(Transaction.HIGH_FREQUENCY_SMALL_INTERVAL);
                        }else{
                            if(iAccountRepository.getAccount(transactionStdInDto.getAccountId()).haveSimilarTransactions(transactionStdInDto.getTime(),transactionStdInDto.getTime(),transactionStdInDto.getAmount(),transactionStdInDto.getMerchant())){
                                accountSpecOutDto.addViolation(Transaction.DOUBLED_TRANSACTION);
                            }else{
                                iAccountRepository.getAccount(transactionStdInDto.getAccountId()).addTransaction(transaction);
                                iTransactionRepository.saveTransaction(transaction);
                                iAccountRepository.getAccount(transaction.getAccountId()).decreaseAmount(transactionStdInDto.getAmount());
                                accountSpecOutDto.setAvailableLimit(iAccountRepository.getAccount(transactionStdInDto.getAccountId()).getAvailableLimit());
                                accountSpecOutDto.setActiveCard(iAccountRepository.getAccount(transactionStdInDto.getAccountId()).getActiveCard());
                                accountSpecOutDto.setAvailableLimit(iAccountRepository.getAccount(transactionStdInDto.getAccountId()).getAvailableLimit());
                            }
                        }
                    }else{
                        if(iAccountRepository.getAccount(transaction.getAccountId()).haveSimilarTransactions(transactionStdInDto.getTime(),transactionStdInDto.getTime(),transactionStdInDto.getAmount(),transactionStdInDto.getMerchant())){
                            accountSpecOutDto.addViolation(Transaction.DOUBLED_TRANSACTION);
                        }else{
                            iAccountRepository.getAccount(transactionStdInDto.getAccountId()).addTransaction(transaction);
                            iTransactionRepository.saveTransaction(transaction);
                            iAccountRepository.getAccount(transaction.getAccountId()).decreaseAmount(transactionStdInDto.getAmount());
                            accountSpecOutDto.setAvailableLimit(iAccountRepository.getAccount(transactionStdInDto.getAccountId()).getAvailableLimit());
                            accountSpecOutDto.setActiveCard(iAccountRepository.getAccount(transactionStdInDto.getAccountId()).getActiveCard());
                            accountSpecOutDto.setAvailableLimit(iAccountRepository.getAccount(transactionStdInDto.getAccountId()).getAvailableLimit());
                        }
                    }
                }else{
                    accountSpecOutDto.addViolation(Account.INSUFFICIENT_LIMIT);
                    accountSpecOutDto.setActiveCard(iAccountRepository.getAccount(transactionStdInDto.getAccountId()).getActiveCard());
                    accountSpecOutDto.setAvailableLimit(iAccountRepository.getAccount(transactionStdInDto.getAccountId()).getAvailableLimit());

                }
            }else{
                accountSpecOutDto.addViolation(Account.CARD_NOT_ACTIVE);
                accountSpecOutDto.setActiveCard(iAccountRepository.getAccount(transactionStdInDto.getAccountId()).getActiveCard());
                accountSpecOutDto.setAvailableLimit(iAccountRepository.getAccount(transactionStdInDto.getAccountId()).getAvailableLimit());

            }
        }else{
            accountSpecOutDto.addViolation(Account.ACCOUNT_NOT_INITIALIZED);
        }
        return accountSpecOutDto;
    }

    /**
     * Method that get all transactions
     * @return
     */
    @Override
    public List<TransactionStdOutDto> getAll() {
        List<Transaction> transactions = iTransactionRepository.getAll();
        List<TransactionStdOutDto> transactionsStdOutDtos = ITransactionMapperImpl.INSTANCE.asTransactionListEntitiesToTransactionListStdOutDto(transactions);
        return transactionsStdOutDtos;
    }
}
