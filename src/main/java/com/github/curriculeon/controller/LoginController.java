package com.github.curriculeon.controller;

import com.github.curriculeon.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/login")
public class LoginController {
    @Autowired
    private LoginService service;

    @RequestMapping(method = RequestMethod.GET, value = "/{username}/{password}")
    public ResponseEntity<?> login(
            @PathVariable String username,
            @PathVariable String password) { // TODO - replace @PathVariable with @RequestParam
        try {
            return new ResponseEntity<>(service.login(username, password), HttpStatus.OK);
        } catch (Throwable t) {
            return new ResponseEntity<>(t.getMessage(), null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
