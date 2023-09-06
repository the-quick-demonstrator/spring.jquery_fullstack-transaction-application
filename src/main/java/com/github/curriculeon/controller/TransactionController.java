package com.github.curriculeon.controller;

import com.github.curriculeon.model.Account;
import com.github.curriculeon.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/transactions/")
public class TransactionController {
    @Autowired
    private TransactionService service;

    @RequestMapping(method = RequestMethod.PUT, value = "/accounts/{accountId}/deposit/{amount}")
    public ResponseEntity<Account> deposit(@PathVariable Long accountId, @PathVariable Double amount) {
        return new ResponseEntity<>(service.deposit(accountId, amount), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/accounts/{accountId}/withdrawal/{amount}")
    public ResponseEntity<Account> withdrawal(@PathVariable Long accountId, @PathVariable Double amount) {
        return new ResponseEntity<>(service.withdrawal(accountId, amount), HttpStatus.OK);
    }
}
