package com.example.demo.repositories;

import com.example.demo.tables.Conference;
import com.example.demo.tables.ConferenceRoom;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ConferenceRepository extends CrudRepository<Conference, Long> {
    List<Conference> findByName(String name);
}
