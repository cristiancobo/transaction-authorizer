package com.lulobank.authorizer.service.interfaces;

import com.lulobank.authorizer.controller.dto.specout.AccountSpecOutDto;
import com.lulobank.authorizer.controller.dto.stdin.AccountStdInDto;
import com.lulobank.authorizer.controller.dto.stdout.AccountStdOutDto;
import com.lulobank.authorizer.entity.Account;

import java.util.List;

public interface IAccountService {

    public AccountStdOutDto getAccount(int id);

    public AccountSpecOutDto saveAccount(AccountStdInDto accountStdInDto);

    public List<AccountStdOutDto> getAll();
}
