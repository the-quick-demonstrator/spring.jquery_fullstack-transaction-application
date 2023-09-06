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

    @RequestMapping(method = RequestMethod.POST, value = "/create")
    public ResponseEntity<Account> create(@RequestBody Account account) {
        return new ResponseEntity<>(service.create(account), HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/read-all")
    public ResponseEntity<List<Account>> readAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/read/{id}")
    public ResponseEntity<Account> readById(@PathVariable Long id) {
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }


    @RequestMapping(method = RequestMethod.PUT, value = "/update/{id}")
    public ResponseEntity<Account> updateById(@PathVariable Long id, @RequestBody Account account) {
        return new ResponseEntity<>(service.updateById(id, account), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete/{id}")
    public ResponseEntity<Account> deleteById(@PathVariable Long id) {
        return new ResponseEntity<>(service.deleteById(id), HttpStatus.OK);
    }
}
