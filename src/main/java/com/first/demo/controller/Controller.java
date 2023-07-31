package com.first.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.first.demo.model.RegistrationForm;
import com.first.demo.service.RegistrationService;

@RestController
@RequestMapping("/api")
//@CrossOrigin(origins = "http://localhost:4200")
public class Controller {

    @Autowired
    private RegistrationService registrationService;

    @PostMapping(value = "/register")
    public ResponseEntity<String> register(@RequestBody RegistrationForm registrationForm) {
        try {
            registrationService.registerUser(registrationForm.getEmail(), registrationForm.getPassword(), registrationForm.getName());
            return ResponseEntity.ok("Registration successful");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}


