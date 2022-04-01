package com.lulobank.authorizer.service.mapper;

import com.lulobank.authorizer.controller.dto.specout.AccountSpecOutDto;
import com.lulobank.authorizer.controller.dto.stdin.AccountStdInDto;
import com.lulobank.authorizer.controller.dto.stdout.AccountStdOutDto;
import com.lulobank.authorizer.entity.Account;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-04-01T11:31:09-0500",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.4.1.jar, environment: Java 11.0.11 (Oracle Corporation)"
)
public class IAccountMapperImpl implements IAccountMapper {

    @Override
    public AccountStdOutDto asAccountToAccountStdoutDto(Account account) {
        if ( account == null ) {
            return null;
        }

        AccountStdOutDto accountStdOutDto = new AccountStdOutDto();

        accountStdOutDto.setId( account.getId() );
        accountStdOutDto.setActiveCard( account.getActiveCard() );
        accountStdOutDto.setAvailableLimit( account.getAvailableLimit() );
        List<String> list = account.getViolations();
        if ( list != null ) {
            accountStdOutDto.setViolations( new ArrayList<String>( list ) );
        }

        return accountStdOutDto;
    }

    @Override
    public AccountSpecOutDto asAccountToAccountSpecOutDto(Account account) {
        if ( account == null ) {
            return null;
        }

        AccountSpecOutDto accountSpecOutDto = new AccountSpecOutDto();

        accountSpecOutDto.setActiveCard( account.getActiveCard() );
        accountSpecOutDto.setAvailableLimit( account.getAvailableLimit() );
        List<String> list = account.getViolations();
        if ( list != null ) {
            accountSpecOutDto.setViolations( new ArrayList<String>( list ) );
        }

        return accountSpecOutDto;
    }

    @Override
    public Account asAccountStdInDtotoAccount(AccountStdInDto accountStdInDto) {
        if ( accountStdInDto == null ) {
            return null;
        }

        boolean activeCard = false;
        int availableLimit = 0;

        activeCard = accountStdInDto.isActiveCard();
        availableLimit = accountStdInDto.getAvailableLimit();

        Account account = new Account( activeCard, availableLimit );

        account.setId( accountStdInDto.getId() );
        List<String> list = accountStdInDto.getViolations();
        if ( list != null ) {
            account.setViolations( new ArrayList<String>( list ) );
        }

        return account;
    }

    @Override
    public List<AccountStdOutDto> asAccountListEntitiesToAccountListStdOutDto(List<Account> accounts) {
        if ( accounts == null ) {
            return null;
        }

        List<AccountStdOutDto> list = new ArrayList<AccountStdOutDto>( accounts.size() );
        for ( Account account : accounts ) {
            list.add( asAccountToAccountStdoutDto( account ) );
        }

        return list;
    }

    @Override
    public List<AccountSpecOutDto> asAccountListEntitiesToAccountListSpecOutDto(List<Account> accounts) {
        if ( accounts == null ) {
            return null;
        }

        List<AccountSpecOutDto> list = new ArrayList<AccountSpecOutDto>( accounts.size() );
        for ( Account account : accounts ) {
            list.add( asAccountToAccountSpecOutDto( account ) );
        }

        return list;
    }
}
