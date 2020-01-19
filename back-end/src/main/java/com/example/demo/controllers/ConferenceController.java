package com.example.demo.controllers;

import com.example.demo.repositories.ConferenceRepository;
import com.example.demo.tables.Conference;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = {"http://localhost:8081",
        "http://localhost:8081/manageConference", "http://localhost:8081/viewConference"})
@RestController
public class ConferenceController {

    @Autowired
    ConferenceRepository repository;


    @PostMapping("/addConference")
    public void addConference(@RequestBody JSONObject request) throws ParseException {
        String request_date = request.getAsString("date");
        SimpleDateFormat output = new SimpleDateFormat("dd.MM.yyyy HH:mm");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        Date date = sdf.parse(request_date);
        request_date = output.format(date);

        Conference conference = new Conference(request.getAsString("name"), request.getAsString("location"),
                request_date, Integer.parseInt(request.get("max_seats").toString()),
                "ACTIVE");
        repository.save(conference);

    }

    @GetMapping("/conferences")
    public List getAll() {
        return repository.findAll();
    }

    @DeleteMapping("/deleteConference/{id}")
    public ResponseEntity<Void> deleteConferenceById(@PathVariable long id) {

        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }


    @GetMapping("/getConferenceById/{id}")
    public Optional<Conference> findById(@PathVariable long id) {
        return repository.findById(id);
    }
}
