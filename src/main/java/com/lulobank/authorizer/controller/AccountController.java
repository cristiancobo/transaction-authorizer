package com.lulobank.authorizer.controller;

import com.lulobank.authorizer.controller.dto.specout.AccountSpecOutDto;
import com.lulobank.authorizer.controller.dto.stdin.AccountStdInDto;

import com.lulobank.authorizer.controller.dto.stdout.AccountStdOutDto;
import com.lulobank.authorizer.service.interfaces.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * Class that represents accont controller
 */
@RestController
@RequestMapping("/api/v1.0/accounts")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
public class AccountController {
    private IAccountService iAccountService;

    /**
     * Methods
     */
    @Autowired
    public AccountController(IAccountService iAccountService) {
        this.iAccountService = iAccountService;
    }
    @GetMapping("/{id}")
    public ResponseEntity<AccountStdOutDto> getAccount(@PathVariable int id){
        return new ResponseEntity<AccountStdOutDto>(iAccountService.getAccount(id), HttpStatus.OK);
    }
    @PostMapping("/")
    public ResponseEntity<AccountSpecOutDto> saveAccount(@RequestBody AccountStdInDto accountStdInDto){
        return new ResponseEntity<AccountSpecOutDto>(iAccountService.saveAccount(accountStdInDto),HttpStatus.OK);
    }
    @GetMapping("/")
    public ResponseEntity<List<AccountStdOutDto>> getAll(){
        return new ResponseEntity<List<AccountStdOutDto>>(iAccountService.getAll(), HttpStatus.OK);
    }




}
