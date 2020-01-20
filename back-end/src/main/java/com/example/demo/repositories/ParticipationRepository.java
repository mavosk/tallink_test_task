package com.example.demo.repositories;

import com.example.demo.tables.Participation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ParticipationRepository extends JpaRepository<Participation, Long> {
    List<Participation> findById(long id);

    @Query("SELECT p FROM Participation p WHERE  p.conference_id= :conference_id")
    List<Participation> getConferenceParticipation(@Param("conference_id") long conference_id);

    @Query("SELECT count(p) FROM Participation p WHERE  p.conference_id= :conference_id")
    Long countParticipant(@Param("conference_id") long conference_id);
}
