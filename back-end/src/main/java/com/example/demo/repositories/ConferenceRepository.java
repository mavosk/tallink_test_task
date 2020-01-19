package com.example.demo.repositories;

import com.example.demo.tables.Conference;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ConferenceRepository extends JpaRepository<Conference, Long> {
    List<Conference> findByName(String name);
}
