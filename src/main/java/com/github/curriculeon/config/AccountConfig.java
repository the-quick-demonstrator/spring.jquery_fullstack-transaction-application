package com.github.curriculeon.config;

import com.github.curriculeon.model.Account;
import com.github.curriculeon.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class AccountConfig {
    @Autowired
    private AccountRepository repository;

    @PostConstruct
    public void setup() {
        repository.save(new Account());
    }
}
