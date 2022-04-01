package com.lulobank.authorizer.service.interfaces;

import com.lulobank.authorizer.controller.dto.specout.AccountSpecOutDto;
import com.lulobank.authorizer.controller.dto.stdin.TransactionStdInDto;
import com.lulobank.authorizer.controller.dto.stdout.AccountStdOutDto;
import com.lulobank.authorizer.controller.dto.stdout.TransactionStdOutDto;

import java.util.List;

public interface ITransactionService {
    public TransactionStdOutDto getTransaction(int id);
    public AccountSpecOutDto saveTransaction(TransactionStdInDto transactionStdInDto);
    public List<TransactionStdOutDto> getAll();
}
