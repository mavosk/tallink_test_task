package com.example.demo.controllers;

import com.example.demo.repositories.ConferenceRoomRepository;
import com.example.demo.tables.ConferenceRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ConferenceRoomController {

    @Autowired
    ConferenceRoomRepository repository;
    @RequestMapping("/save")
    public String process(){
        repository.save(new ConferenceRoom(	"M/S Baltic Queen conference"	,"M/S	Baltic	Queen", 124));
        repository.save(new ConferenceRoom("M/S  Silja Line", "M/S	 Silja Line", 100));
        repository.save(new ConferenceRoom("M/S Romantika room", "M/S	 Romantika room", 50));
        repository.save(new ConferenceRoom("M/S Megastar", "M/S	 Megastar", 80));
        return "Done";
    }

    @RequestMapping("/allRooms")
    public List findAll(){
        List<ConferenceRoom> result = new ArrayList<>();

        for(ConferenceRoom room : repository.findAll()){
            result.add(room);
        }

        return result;
    }

    @RequestMapping("/findbylocation")
    public String fetchDataByLastName(@RequestParam("location") String location){
        StringBuilder result = new StringBuilder();

        for(ConferenceRoom room: repository.findByLocation(location)){
            result.append(room.toString()).append("</br>");
        }

        return result.toString();
    }


}
