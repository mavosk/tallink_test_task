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


        String request_date = request.getAsString("birth_date");
        SimpleDateFormat input = new SimpleDateFormat("yyyy-MM-dd");
        Date date = input.parse(request_date);

        Participation participation = new Participation(
                request.getAsString("name"),
                date,
                Integer.parseInt(request.get("conference_id").toString()
                ));
        repository.save(participation);
    }

    @GetMapping("/participations")
    public List getAll() {
        List<Participation> result = new ArrayList<>();
        for (Participation participant : repository.findAll()) {
            result.add(participant);
        }
        return result;
    }

    @DeleteMapping("/deleteParticipation/{id}")
    public ResponseEntity<Void> deleteParticipationById(@PathVariable long id) {

        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }





}
