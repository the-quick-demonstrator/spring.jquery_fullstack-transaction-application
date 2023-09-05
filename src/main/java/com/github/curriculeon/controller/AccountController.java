package com.github.curriculeon.controller;

import com.github.curriculeon.model.Account;
import com.github.curriculeon.model.Transaction;
import com.github.curriculeon.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/account-controller")
public class AccountController {
    @Autowired
    private AccountService service;

    @RequestMapping(method = RequestMethod.PUT, value = "/readAll")
    public ResponseEntity<List<Account>> readAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }
    @RequestMapping(method = RequestMethod.PUT, value = "/deposit")
    public ResponseEntity<Account> deposit(@RequestBody Transaction transaction) {
        return new ResponseEntity<>(service.deposit(transaction.getAccountId(), transaction.getDeposit()), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/withdrawal")
    public ResponseEntity<Account> withdrawal(@RequestBody Transaction transaction) {
        return new ResponseEntity<>(service.withdrawal(transaction.getAccountId(), transaction.getWithdrawal()), HttpStatus.OK);
    }
}
