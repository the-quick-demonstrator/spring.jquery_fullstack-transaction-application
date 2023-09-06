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
@RequestMapping(value = "/accounts/")
public class AccountController {
    @Autowired
    private AccountService service;

    @RequestMapping(method = RequestMethod.PUT, value = "/readAll")
    public ResponseEntity<List<Account>> readAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }
    @RequestMapping(method = RequestMethod.GET, value = "/login/{username}/{password}")
    public ResponseEntity<Account> login( // TODO - replace @PathVariable with @RequestParam
            @PathVariable String username,
            @PathVariable String password) {
        if(username.equals("leon") && password.equals("hunter")) {
            return new ResponseEntity<>(new Account(1L, Double.MAX_VALUE), HttpStatus.OK);
        }
        return new ResponseEntity<>(new Account(Long.MAX_VALUE, Double.MIN_VALUE), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @RequestMapping(method = RequestMethod.GET, value = "/read/{id}")
    public ResponseEntity<Account> readById(@PathVariable Long id) {
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
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
