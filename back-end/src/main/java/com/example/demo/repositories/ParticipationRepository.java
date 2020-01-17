package com.example.demo.repositories;

import com.example.demo.tables.Participation;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ParticipationRepository extends CrudRepository<Participation, Long> {
    List<Participation> findById(long id);
}
