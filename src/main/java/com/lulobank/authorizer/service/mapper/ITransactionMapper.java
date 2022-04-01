package com.lulobank.authorizer.service.mapper;

import com.lulobank.authorizer.controller.dto.stdin.AccountStdInDto;
import com.lulobank.authorizer.controller.dto.stdin.TransactionStdInDto;
import com.lulobank.authorizer.controller.dto.stdout.AccountStdOutDto;
import com.lulobank.authorizer.controller.dto.stdout.TransactionStdOutDto;
import com.lulobank.authorizer.entity.Account;
import com.lulobank.authorizer.entity.Transaction;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;
@Mapper
public interface ITransactionMapper {
    ITransactionMapper INSTANCE = Mappers.getMapper(ITransactionMapper.class);
    TransactionStdOutDto asTransactionToTransactionStdoutDto(Transaction transaction);
    Transaction asTransactionStdInDtoToTransaction(TransactionStdInDto transactionStdInDto);
    List<TransactionStdOutDto> asTransactionListEntitiesToTransactionListStdOutDto(List<Transaction> transactions);
}
