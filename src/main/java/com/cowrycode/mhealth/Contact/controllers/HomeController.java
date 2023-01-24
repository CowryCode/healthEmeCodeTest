package com.cowrycode.mhealth.Contact.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public ResponseEntity<String> start(){
        return new ResponseEntity<>("HealthEme Backend is live !!!", HttpStatus.OK);
    }
}
