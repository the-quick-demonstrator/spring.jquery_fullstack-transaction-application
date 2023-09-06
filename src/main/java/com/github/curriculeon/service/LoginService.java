package com.github.curriculeon.service;

import com.github.curriculeon.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class LoginService {
    @Autowired
    private AccountService service;

    public Account login(String username, String password) {
        final String finalUsername = Objects.requireNonNull(username);
        final String finalPassword = Objects.requireNonNull(password);
        return service
                .findAll()
                .stream()
                .filter(account -> finalUsername.equals(account.getUsername()) && finalPassword.equals(account.getPassword()))
                .findFirst()
                .get();
    }
}
