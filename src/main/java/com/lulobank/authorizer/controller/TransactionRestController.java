package com.lulobank.authorizer.controller;

import com.lulobank.authorizer.controller.dto.specout.AccountSpecOutDto;
import com.lulobank.authorizer.controller.dto.stdin.TransactionStdInDto;
import com.lulobank.authorizer.controller.dto.stdout.TransactionStdOutDto;
import com.lulobank.authorizer.service.interfaces.ITransactionService;
import com.lulobank.authorizer.util.exception.InvalidDataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
/**
 * class that represents a transaction controller
 */
@RestController
@RequestMapping("/api/v1.0/transactions")
public class TransactionRestController {

    private ITransactionService iTransactionService;
    /**
     * Methods
     */
    @Autowired
    public TransactionRestController(ITransactionService iTransactionService) {
        this.iTransactionService = iTransactionService;
    }
    @GetMapping("/{id}")
    public ResponseEntity<TransactionStdOutDto> getTransaction(@PathVariable int id){
        return new ResponseEntity<TransactionStdOutDto>(iTransactionService.getTransaction(id), HttpStatus.OK);

    }
    @PostMapping("/")
    public ResponseEntity<AccountSpecOutDto> saveTransaction(@Valid @RequestBody TransactionStdInDto transactionStdInDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()) {
            throw new InvalidDataException(bindingResult);
        }
        return new ResponseEntity<AccountSpecOutDto>(iTransactionService.saveTransaction(transactionStdInDto),HttpStatus.OK);
    }
    @GetMapping("/")
    public ResponseEntity<List<TransactionStdOutDto>> getAll(){
        return new ResponseEntity<List<TransactionStdOutDto>>(iTransactionService.getAll(), HttpStatus.OK);
    }
}
