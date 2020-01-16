package com.example.demo.repositories;

import com.example.demo.tables.ConferenceRoom;
import com.example.demo.tables.Participantion;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ParticipationRepository extends CrudRepository<Participantion, Long> {
    List<Participantion> findById(long id);
}
