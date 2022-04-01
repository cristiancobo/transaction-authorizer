package com.lulobank.authorizer.service.mapper;

import com.lulobank.authorizer.controller.dto.specout.AccountSpecOutDto;
import com.lulobank.authorizer.controller.dto.stdin.AccountStdInDto;
import com.lulobank.authorizer.controller.dto.stdout.AccountStdOutDto;
import com.lulobank.authorizer.entity.Account;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface IAccountMapper {
    IAccountMapper INSTANCE = Mappers.getMapper(IAccountMapper.class);
    AccountStdOutDto asAccountToAccountStdoutDto(Account account);
    AccountSpecOutDto asAccountToAccountSpecOutDto(Account account);
    Account asAccountStdInDtotoAccount(AccountStdInDto accountStdInDto);
    List<AccountStdOutDto> asAccountListEntitiesToAccountListStdOutDto(List<Account> accounts);
    List<AccountSpecOutDto> asAccountListEntitiesToAccountListSpecOutDto(List<Account> accounts);
}
