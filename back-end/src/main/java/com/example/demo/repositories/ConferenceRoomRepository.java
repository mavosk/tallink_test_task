package com.example.demo.repositories;

import java.util.List;

import com.example.demo.tables.ConferenceRoom;
import org.springframework.data.repository.CrudRepository;



public interface ConferenceRoomRepository extends CrudRepository<ConferenceRoom, Long>{
    List<ConferenceRoom> findByLocation(String location);
}
