package com.example.demo.controllers;

import com.example.demo.repositories.ConferenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConferenceController {

    @Autowired
    ConferenceRepository repository;

    @RequestMapping("/saveConf")
    public String saveConference() {
        return "Done";
    }
}
