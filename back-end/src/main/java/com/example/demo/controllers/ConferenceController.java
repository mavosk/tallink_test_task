package com.example.demo.controllers;

import com.example.demo.repositories.ConferenceRepository;
import com.example.demo.tables.Conference;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = { "http://localhost:8081", "http://localhost:8081/registerConference",
        "http://localhost:8081/manageConference", "http://localhost:8081/viewConference" })
@RestController
public class ConferenceController {

    @Autowired
    ConferenceRepository repository;



    @PostMapping("/addConference")
    public void addConference(@RequestBody JSONObject request) {
        System.out.println(request);
        Conference conference = new Conference(request.getAsString("name"), request.getAsString("location"),
                request.getAsString("date"), Integer.parseInt(request.get("max_seats").toString()),
                "ACTIVE");
        repository.save(conference);

    }

    @GetMapping("/conferences")
    public List getAll() {
        List<Conference> result = new ArrayList<>();
        for(Conference room : repository.findAll()){
            result.add(room);
        }
        return result;
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
