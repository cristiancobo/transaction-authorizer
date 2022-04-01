package com.lulobank.authorizer.service.mapper;

import com.lulobank.authorizer.controller.dto.stdin.TransactionStdInDto;
import com.lulobank.authorizer.controller.dto.stdout.TransactionStdOutDto;
import com.lulobank.authorizer.entity.Transaction;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-04-01T11:35:46-0500",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.4.1.jar, environment: Java 11.0.11 (Oracle Corporation)"
)
public class ITransactionMapperImpl implements ITransactionMapper {

    @Override
    public TransactionStdOutDto asTransactionToTransactionStdoutDto(Transaction transaction) {
        if ( transaction == null ) {
            return null;
        }

        TransactionStdOutDto transactionStdOutDto = new TransactionStdOutDto();

        transactionStdOutDto.setId( transaction.getId() );
        transactionStdOutDto.setAccountId( transaction.getAccountId() );
        transactionStdOutDto.setMerchant( transaction.getMerchant() );
        transactionStdOutDto.setAmount( transaction.getAmount() );
        transactionStdOutDto.setTime( transaction.getTime() );

        return transactionStdOutDto;
    }

    @Override
    public Transaction asTransactionStdInDtoToTransaction(TransactionStdInDto transactionStdInDto) {
        if ( transactionStdInDto == null ) {
            return null;
        }

        int accountId = 0;
        String merchant = null;
        int amount = 0;

        accountId = transactionStdInDto.getAccountId();
        merchant = transactionStdInDto.getMerchant();
        amount = transactionStdInDto.getAmount();

        int id = 0;

        Transaction transaction = new Transaction( id, accountId, merchant, amount );

        transaction.setTime( transactionStdInDto.getTime() );

        return transaction;
    }

    @Override
    public List<TransactionStdOutDto> asTransactionListEntitiesToTransactionListStdOutDto(List<Transaction> transactions) {
        if ( transactions == null ) {
            return null;
        }

        List<TransactionStdOutDto> list = new ArrayList<TransactionStdOutDto>( transactions.size() );
        for ( Transaction transaction : transactions ) {
            list.add( asTransactionToTransactionStdoutDto( transaction ) );
        }

        return list;
    }
}
