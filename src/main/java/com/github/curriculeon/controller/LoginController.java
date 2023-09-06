package com.github.curriculeon.controller;

import com.github.curriculeon.model.Account;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/login")
public class LoginController {
    @RequestMapping(method = RequestMethod.GET, value = "/{username}/{password}")
    public ResponseEntity<Account> login(
            @PathVariable String username,
            @PathVariable String password) { // TODO - replace @PathVariable with @RequestParam
        if (username.equals("leon") && password.equals("hunter")) {
            return new ResponseEntity<>(new Account(1L, "Leon", "Hunter", Double.MAX_VALUE), HttpStatus.OK);
        }
        return new ResponseEntity<>(new Account(Long.MAX_VALUE, null, null, Double.MIN_VALUE), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
