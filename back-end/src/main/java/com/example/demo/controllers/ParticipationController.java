package com.example.demo.controllers;

import com.example.demo.repositories.ParticipationRepository;
import com.example.demo.tables.Participation;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = {"http://localhost:8081", "http://localhost:8081/viewConference"})
@RestController
public class ParticipationController {

    @Autowired
    ParticipationRepository repository;

    @PostMapping("/addParticipation")
    public void addParticipation(@RequestBody JSONObject request) throws ParseException {

        Participation participation = new Participation(
                request.getAsString("name"),
                request.getAsString("birth_date"),
                Integer.parseInt(request.get("conference_id").toString()
                ));
        repository.save(participation);
    }

    @GetMapping("/participation")
    public List getAll() {
        List<Participation> result = new ArrayList<>();
        for (Participation participant : repository.findAll()) {
            result.add(participant);
        }
        return result;
    }

    @GetMapping("/participation/{conference_id}")
    public List getConferenceParticipation(@PathVariable long conference_id) {
        List<Participation> result = new ArrayList<>();
        for (Participation participant : repository.findAll()) {
            if (participant.conference_id == conference_id) {
                result.add(participant);
            }
        }
        return result;
    }

    @GetMapping("/countParticipation/{conference_id}")
    public Long getCount(@PathVariable long conference_id) {
        long count = 0L;
        for (Participation participant : repository.findAll()) {
            if (participant.conference_id == conference_id) {
                count++;
            }
        }
        return count;
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
