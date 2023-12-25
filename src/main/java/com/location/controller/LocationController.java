package com.location.controller;

import com.location.service.KafkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/location")
public class LocationController {

    @Autowired
    private KafkaService kafkaService;

    @PostMapping("/update")
    public ResponseEntity<?> updateLocation(){
        this.kafkaService.updateLocation("( "+Math.round(Math.random()*100)+" , "+Math.round(Math.random()*100)+")");
        // We want to create 1000 of new location updated message then we can pass this inside a for loop.
        return new ResponseEntity<>(Map.of("Hello","Location Updated"),HttpStatus.OK);
    }
}
