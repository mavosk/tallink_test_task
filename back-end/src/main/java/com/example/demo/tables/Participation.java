package com.example.demo.tables;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;


@Data
@NoArgsConstructor
@Table(name="participation")
@Entity
public class Participation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public long id;
    @Column(name = "full_name")
    public String name;
    @Column(name="conference_id")
    public long conference_id;
    @Column(name = "birth_date")
    public Date birth_date;

    public Participation(String name, Date birth_date, long conference_id) {
        this.name = name;
        this.conference_id = conference_id;
        this.birth_date = birth_date;
    }

    @Override
    public String toString() {
        return "Participation{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birth_date=" + birth_date +
                '}';
    }
}
