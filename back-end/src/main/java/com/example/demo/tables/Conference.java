package com.example.demo.tables;

import javafx.util.converter.DateStringConverter;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Data
@NoArgsConstructor
@Table(name="conference")
@Entity
public class Conference {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public long id;
    @Column(name = "name")
    public String name;
    @Column(name = "location")
    public String location;
    @Column(name="date")
    public Date date_time;
    @Column(name = "max_seats")
    public int max_seats;
    @Column(name = "status")
    public String status;
    @Column(name="participant_num")
    public int participant_num;

    public Conference(String name, String location, Date time, int max_seats, String status, int participant_num) {
        this.name = name;
        this.location = location;
        this.date_time = time;
        this.max_seats = max_seats;
        this.status = status;
        this.participant_num = participant_num;

    }

    @Override
    public String toString() {
        return "Conference{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", date_time=" + date_time +
                ", max_seats=" + max_seats +
                ", status='" + status + '\'' +
                ", participant_num=" + participant_num +
                '}';
    }
}
