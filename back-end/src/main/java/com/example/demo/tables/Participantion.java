package com.example.demo.tables;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;


@Data
@NoArgsConstructor
@Table(name="participant")
@Entity
public class Participantion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public long id;
    @Column(name = "Full name")
    public String name;
    @Column(name="converence_id")
    public long conference_id;
    @Column(name = "birth_date")
    public Date birth_date;

    public Participantion(String name,long conference_id, Date birth_date) {
        this.name = name;
        this.conference_id = conference_id;
        this.birth_date = birth_date;
    }

    @Override
    public String toString() {
        return "Participantion{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birth_date=" + birth_date +
                '}';
    }
}
