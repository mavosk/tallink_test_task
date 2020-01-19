package com.example.demo.controllers;

import com.example.demo.repositories.ConferenceRoomRepository;
import com.example.demo.tables.ConferenceRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = { "http://localhost:8081" })
@RestController
public class ConferenceRoomController {

    @Autowired
    ConferenceRoomRepository repository;

    @RequestMapping("/allRooms")
    public List findAll(){
        return repository.findAll();
    }

    @RequestMapping("/findByLocation")
    public String fetchDataByLastName(@RequestParam("location") String location){
        StringBuilder result = new StringBuilder();

        for(ConferenceRoom room: repository.findByLocation(location)){
            result.append(room.toString()).append("</br>");
        }

        return result.toString();
    }


}
