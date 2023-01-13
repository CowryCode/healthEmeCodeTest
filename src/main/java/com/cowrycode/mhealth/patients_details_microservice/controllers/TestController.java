package com.cowrycode.mhealth.patients_details_microservice.controllers;

import com.cowrycode.mhealth.patients_details_microservice.services.TestService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private final TestService testService;

    public TestController(TestService testService) {
       String text = "ABCDESHE";
        this.testService = testService;
    }

    @GetMapping("/")
    public ResponseEntity<String> start(){
        testService.test();
        return new ResponseEntity<>("mHealth App have stated", HttpStatus.OK);
    }
}
