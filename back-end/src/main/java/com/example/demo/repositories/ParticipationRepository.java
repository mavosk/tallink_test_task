package com.example.demo.repositories;

import com.example.demo.tables.Participation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
public interface ParticipationRepository extends JpaRepository<Participation, Long> {
    List<Participation> findById(long id);

    @Query("SELECT p FROM Participation p WHERE  p.conference_id= :conference_id")
    List<Participation> getConferenceParticipation(@Param("conference_id") long conference_id);

    @Query("SELECT count(p) FROM Participation p WHERE  p.conference_id= :conference_id")
    Long countParticipant(@Param("conference_id") long conference_id);

    @Transactional
   @Modifying
    @Query("DELETE FROM Participation p WHERE p.conference_id= :conference_id")
    void deleteAllParticipation(@Param("conference_id") long conference_id);
}
