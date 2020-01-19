package com.example.demo.tables;

import javafx.util.converter.DateStringConverter;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.format.DateTimeFormatter;
import java.sql.Date;

@Data
@NoArgsConstructor
@Table(name="conference")
@Entity
public class Conference {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public long id;
    @Column(name = "name")
    public String name;
    @Column(name = "location")
    public String location;
    @Column(name="date")
    public String date;
    @Column(name = "max_seats")
    public int max_seats;
    @Column(name = "status")
    public String status;


    public Conference(String name, String location, String time, int max_seats, String status) {
        this.name = name;
        this.location = location;
        this.date = time;
        this.max_seats = max_seats;
        this.status = status;

    }

    @Override
    public String toString() {
        return "Conference{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", date=" + date +
                ", max_seats=" + max_seats +
                ", status='" + status + '\'' +
                '}';
    }
}
