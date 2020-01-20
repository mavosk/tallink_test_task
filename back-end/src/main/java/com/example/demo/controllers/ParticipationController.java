package com.example.demo.controllers;

import com.example.demo.repositories.ParticipationRepository;
import com.example.demo.tables.Participation;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@CrossOrigin(origins = {"http://localhost:8081", "http://localhost:8081/viewConference"})
@RestController
public class ParticipationController{

    @Autowired
    ParticipationRepository repository;

    @PostMapping("/addParticipation")
    public void addParticipation(@RequestBody JSONObject request) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        String request_date = request.getAsString("birth_date");
        Date date = sdf.parse(request_date);
        sdf.applyPattern("dd.MM.yyyy");
        request_date = sdf.format(date);

        Participation participation = new Participation(
                request.getAsString("name"),
                request_date,
                Integer.parseInt(request.get("conference_id").toString()
                ));
        repository.save(participation);
    }

    @GetMapping("/participation")
    public List getAll() {
        return repository.findAll();
    }

    @GetMapping("/participation/{conference_id}")
    public List getConferenceParticipation(@PathVariable long conference_id) {
        return repository.getConferenceParticipation(conference_id);
    }

    @GetMapping("/countParticipation/{conference_id}")
    public Long getCount(@PathVariable long conference_id) {
        return repository.countParticipant(conference_id);
    }

    @DeleteMapping("/deleteParticipation/{id}")
    public ResponseEntity<Void> deleteParticipationById(@PathVariable long id) {

        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }


    @DeleteMapping("/deleteAllParticipation/{conference_id}")
    public ResponseEntity<Void> deleteAllParticipationById(@PathVariable long conference_id) {


        for (Participation participant : repository.findAll()) {
            if (participant.conference_id == conference_id) {
                repository.deleteById(participant.id);
            }
        }

        return ResponseEntity.noContent().build();
    }


}
